(ns lab1.core)

;; функция выбрасывает повторяющиеся ключи
(defn remove-repeated-values [maps-stream]
      (let [remove-duplicates (fn [m]
                                  (into {} (filter (fn [[k v]] (not= (first v) (second v))))
                                        (partition-all 2 1 (map vec m))))]
           (map remove-duplicates maps-stream)))

;; Создаёт поток бесконечных ассоциативных массивов
(def inf-seq-of-maps
  (iterate #(assoc % :a (rand-int 5) :b (rand-int 5) :c (rand-int 5))
           {:a 0 :b 0 :c 0}))

;;Возвращает первые 5 элементов изменённой последовательности
(def modified-maps
  (take 5 (remove-repeated-values inf-seq-of-maps)))
