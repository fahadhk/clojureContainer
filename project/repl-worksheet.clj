;; buffer -> file

;; C-x C-c -> kill emacs
;; C-x C-f -> open file
;; C-x C-s -> save file
;; M-x -> save-buffer
;; C-x b -> switch buffer

;; M-f/b -> move forward/backward a word
;; C-k -> kill line after the point
;; C-/ -> undo

;; C-spc -> create regions 
;;       -> select region and press backspace to delete the region
;;       -> select region and M-x replace-string replace string in the selected region

;; M-w -> Add selection to kill ring without deleting it from buffer
;; M-d -> Add selection to kill ring and delete it from buffer

;; In emacs FRAME you can have multiple WINDOWS
;; C-x o switch cursor to another window
;; C-x 2/3 split frame vertically / horizontally
;; C-x 0 delete current window
;; C-x 1 delete all other windows. This does not closes the buffer so no data is lost.

;; M-x -> cider -> cider-connect-clj -> localhost:50000
;; C-c C-e -> execute line in REPL
;; C-c C-k -> compile and run

;; M-( -> wraps the next word
;; (C - ->/<-)  Slurp to right to include next exp/ Barf left to exclude last expression
;; This is sample text for learning to edit in this universe.

(+ 1 (* 2 3) 4)

(defn factorial
  "This is Docstring of a function that calculates factorial"
  ([n] (factorial n 1))
  ([n result] (if (< n 1) 
                result
                (recur (dec n) (* result n)))))

(map factorial [0 1 2 3 4 5 6 7 8])

(defn fibonacci
"This is a docstring for a function that calcultes fibonacci series"
([n] (fibonacci n 0 1))
([n a b] (if (<= n 0) 
           b
           (recur (dec n) b (+ a b)))))

(map fibonacci [-1 0 1 2 3 4 5 6 7])

(defn sumOfNaturalNumbers
  ([n sum] (if (<= n 0)
             sum
             (sumOfNaturalNumbers (dec n) (+ sum n))))
  ([n] (sumOfNaturalNumbers n 0 )))

(map sumOfNaturalNumbers [0 1 2 3 4 5 6 7 8 9])

(reduce + [0 1 2 3 4 5 6])

(filter #(< 100 %) [10 20 40 80 160 320])

(defn powOfNumber
([x n] (if (= n 0)
         1
         (* x (powOfNumber x (dec n))))))

(powOfNumber 2 8)

(defn powXN
([x n] (powXN x n 1))
([x n p] (if (= n 0)
           p
           (recur x (dec n) (* p x)))))

(defn sleep-identity
  "Returns the given value after 1 second"
  [x]
  (Thread/sleep 1000)
  x)

(sleep-identity "Mr. Fantastico")

(sleep-identity "Mr. Fantastico")

(def memo-sleep-identity (memoize sleep-identity))

(memo-sleep-identity "Mr. Fantastico")

;; Reference: "Clojure for Brave and True"
