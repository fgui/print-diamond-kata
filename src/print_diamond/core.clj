(ns print-diamond.core
  (:gen-class))

(defn A-to-str [s]
  (map char (range (int \A) (inc (int (first s))))))

(defn mirror [a-seq]
  (concat a-seq (drop 1 (reverse a-seq))))

(defn keep-char [line c]
  (map #(if (= c %) % \space) line))

(defn diamond [s]
  (let [abc (A-to-str s)
        l (mirror (reverse abc))]
    (mirror (map #(keep-char l %) abc))))

(defn print-diamond [s]
  (doseq [l (diamond s)]
    (println (apply str l))))

(defn -main
  [& args]
  (println-diamond (first args)))
