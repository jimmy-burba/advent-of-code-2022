(require '[clojure.string :as str])

(def lines
  (str/split
   (slurp "/home/jimmy/src/advent-of-code-2022/01-input.txt")
   #"\n"))

(defn findMax [curr maximum remainingLines]
  (if (<= (count remainingLines) 0)
    maximum
    (let [currentLine (first remainingLines)
          currentNum (if (= currentLine "")
                       0
                       (Integer/parseInt currentLine))
          currentSum (if (= currentNum 0)
                       currentNum
                       (+ currentNum curr))]
      (findMax currentSum (max maximum currentSum) (rest remainingLines)))))

(def result (findMax 0 0 lines))