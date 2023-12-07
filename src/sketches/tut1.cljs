(ns sketches.tut1
  (:require
   [quil.core :as q]
   [sketches.menu :as menu]
   ))

;; Example 1 - Cross with Circle
;; Taken from Section 2.2.1, p20

;; size(500, 300);
;; smooth();
;; background(230, 230, 230);
;; //draw two crossed lines
;; stroke(130, 0, 0);
;; strokeWeight(4);
;; line(width/2 - 70, height/2 - 70, width/2 + 70, height/2 + 70);
;; line(width/2 + 70, height/2 - 70, width/2 - 70, height/2 + 70);
;; //draw a filled circle too
;; fill(255, 150);
;; ellipse(width/2, height/2, 50, 50);
(def body (.-body js/document))
(def w (.-clientWidth body))
(def h (.-clientHeight body))

(defn setup []
  (q/smooth)
  (q/background 230 230 230)
  (q/stroke 130, 0 0)
  (q/stroke-weight 4)
  (let [cross-size      70
        circ-size       50
        canvas-x-center (/ (q/width) 2)
        canvas-y-center (/ (q/height) 2)
        left            (- canvas-x-center cross-size)
        right           (+ canvas-x-center cross-size)
        top             (+ canvas-y-center cross-size)
        bottom          (- canvas-y-center cross-size)]
    (q/line left bottom right top)
    (q/line right bottom left top)

    (q/fill 255 150)
    (q/ellipse canvas-x-center canvas-y-center circ-size circ-size)))

(defn draw [])


(defn start []
  (q/sketch
   :host "sketch"
   :title "Cross with circle"
   :mouse-released menu/printlick
   :setup setup
   :draw draw
   :size [w h]))

(defonce sketchy (start))
