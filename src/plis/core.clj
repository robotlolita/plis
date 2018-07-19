(ns plis.core
  (:require [clojure.edn :as edn]
            [clojure.core.match :refer [match]])
  (:gen-class))

(defn eval-expr [expr env]
  (match [expr]
    [(['fn x body] :seq)] 
      (fn [arg]
        (eval-expr body
          (fn [y] (if (= x y) arg
                  (env y)))))

    [([f x] :seq)]
      ((eval-expr f env) (eval-expr x env))
    
    [x :guard #(symbol? %)]
      (env x)

    :else expr)) ;; Reuse host values!

(defn parse [source]
  (edn/read-string source))

(defn run [source]
  (eval-expr (parse source) (fn [x] (throw (Exception. (str "No binding " x))))))
  

(defn -main
  [& args]
  (let [source (first args)]
    (println "Input:")
    (println source)
    (println "")
    (println "Output:")
    (println (run source))))
