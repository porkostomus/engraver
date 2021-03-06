(ns engraver.app
  (:require [reagent.core :as r]))

(defn brace []
  [:path {:transform "translate (0.7,7.825) scale(0.6, 0.7)"
          :d         "M1.731 28.982H1.576v-.084-.084h-.113-.113v-.113-.113h-.113-.113v-.225-.225h-.113-.113v-.225-.225h-.113-.113v-.225-.225H.562.45V26.787 26.337H.338.225v-1.914-1.914h.113.113v-.562-.562h.113.113v-.675-.675h.113.113v-.788-.788h.113.113v-.675-.675h-.113-.113v-.562-.562h-.113-.113v-.338-.338h-.113-.113v-.113-.113H.338.225v-.225-.225H.113 0v-.225-.225h.113.113v-.113-.113h.113.113v-.225-.225h.113.113v-.225-.225h.113.113v-.562-.562h.113.113V11.255 10.58H1.013.901V9.792 9.004H.788.675V8.329 7.654H.562.45V7.09 6.528H.338.225V4.614 2.702h.113.113V2.251 1.801h.113.113v-.225-.225h.113.113v-.225-.225h.113.113v-.225-.225h.113.113V.338.225h.113.113V.113 0H1.731 1.885V.113.225H1.843 1.801v.113.113h-.113-.113v.225.225h-.113-.113v.113.113h-.113-.113v.338.338h-.113-.113v1.801 1.801h.113.113v.675.675h.113.113v.562.562h.113.113v2.026 2.026h-.113-.113v.45.45h-.113-.113v.225.225h-.113-.113v.225.225h-.113-.113v.225.225h-.113-.113v.113.113H.338.225v.113.113h.113.113v.113.113h.113.113v.225.225h.113.113v.225.225h.113.113v.225.225h.113.113v.338.338h.113.113v2.026 2.026h-.113-.113v.675.675h-.113-.113v.675.675h-.113-.113v1.801 1.801h.113.113v.225.225h.113.113v.225.225h.113.113v.225.225h.154.154v.197.197z"}])

(defn bar-line [x]
  [:line {:transform    "translate(3.825,-0.09)"
          :x1           x
          :x2           x
          :y1           8
          :y2           16.2
          :stroke       "black"
          :stroke-width 0.35}])

(defn bar-number [n]
  [:path {:transform (str "translate(" (+ 0.3 (* 24 (dec n))) "," 6.3 ")")
          :d         (case n
                       0 "M.286.999H.143V.928.857H.071 0V.5.143H.071.143V.071 0H.286.428V.071.143H.5.571V.5.857H.5.428V.928.999ZM.286.857H.428V.5.143H.286.143v.357.357z"
                       1 "M.393 1.34H.106V1.245 1.149H.202.297V.765.383H.202.106V.287.191H.202.297V.096 0h.096.096v.574.574H.584.68V1.245 1.34Z"
                       2 "M.542 1.337H.159V1.146.956H.255.35V.86.765H.446.542V.669.573H.637.733V.382.191H.542.35V.382.573H.255.159V.382.191H.255.35V.096 0h.191.191V.096.191H.828.924V.382.573H.828.733V.669.765H.637.542V.86.956H.446.35v.096.096h.287.287v.096.096z"
                       3 "M6 21H3V19.5 18H1.5 0V16.5 15H1.5 3V16.5 18H6 9V15 12H6 3V10.5 9H6 9V6 3H6 3V4.5 6H1.5 0V4.5 3H1.5 3V1.5 0H6 9V1.5 3H10.5 12V6 9H10.5 9v1.5 1.5h1.5 1.5v3 3H10.5 9v1.5 1.5z"
                       4 "M 10.5,21 H 9 V 18 15 H 4.5 0 V 12 9 H 1.5 3 V 7.5 6 H 4.5 6 V 4.5 3 H 7.5 9 V 1.5 0 h 1.5 1.5 v 6 6 H 13.5 15 V 13.5 15 H 13.5 12 v 3 3 z M 6,12 H 9 V 9 6 H 7.5 6 V 7.5 9 H 4.5 3 v 1.5 1.5 z"
                       5 "M 0,15 H 1.5 3 V 16.5 18 H 6 9 V 13.5 9 H 4.5 0 V 4.5 0 h 6 6 V 1.5 3 H 7.5 3 V 4.5 6 H 6 9 V 7.5 9 H 10.5 12 V 13.5 18 H 10.5 9 V 19.5 21 H 6 3 V 19.5 18 H 1.5 0 v -1.5 z"
                       6 "M 6,21 H 3 V 19.5 18 H 1.5 0 V 10.5 3 H 1.5 3 V 1.5 0 H 6 9 V 1.5 3 H 10.5 12 V 4.5 6 H 10.5 9 V 4.5 3 H 6 3 v 3 3 h 3 3 v 1.5 1.5 h 1.5 1.5 v 3 3 H 10.5 9 V 19.5 21 Z M 6,18 H 9 V 15 12 H 6 3 v 3 3 z"
                       7 "M 4.5,21 H 3 V 18 15 H 4.5 6 V 12 9 H 7.5 9 V 6 3 H 6 3 V 4.5 6 H 1.5 0 V 3 0 h 6 6 V 4.5 9 H 10.5 9 v 3 3 H 7.5 6 v 3 3 z"
                       8 "M 6,21 H 3 V 19.5 18 H 1.5 0 V 15 12 H 1.5 3 V 10.5 9 H 1.5 0 V 6 3 H 1.5 3 V 1.5 0 H 6 9 V 1.5 3 H 10.5 12 V 6 9 H 10.5 9 v 1.5 1.5 h 1.5 1.5 v 3 3 H 10.5 9 V 19.5 21 Z M 6,18 H 9 V 15 12 H 6 3 v 3 3 z M 6,9 H 9 V 6 3 H 6 3 v 3 3 z"
                       9 "M 6,21 H 3 V 19.5 18 H 1.5 0 V 16.5 15 H 1.5 3 V 16.5 18 H 6 9 V 15 12 H 6 3 V 10.5 9 H 1.5 0 V 6 3 H 1.5 3 V 1.5 0 H 6 9 V 1.5 3 H 10.5 12 V 10.5 18 H 10.5 9 V 19.5 21 Z M 6,9 H 9 V 6 3 H 6 3 v 3 3 z")}])

(defn beat-line [x n]
  [:g {:transform "translate(14,0)"}
   (if (zero? (mod n 4))
     [:g
      ;[bar-number (inc (/ x 4))]
      [:line {:x1               (* x 6)
              :x2               (* x 6)
              :y1               6
              :y2               8
              :stroke           "orange"
              :stroke-width     0.25
              :stroke-dasharray 0.5}]]
     [:line {:x1               (* x 6)
             :x2               (* x 6)
             :y1               6
             :y2               8
             :stroke           "black"
             :stroke-width     0.075
             :stroke-dasharray 0.5}])])

(defn ending-bar []
  [:g {:transform "translate(1.2,0.06)"}
   [:rect {:x      22.25
           :y      3
           :width  0.24
           :height 11.25
           :ry     0
           :fill   "black"}]
   [:line {:x1           22.125
           :x2           22.125
           :y1           3
           :y2           14.25
           :stroke       "black"
           :stroke-width 0.1}]])

(defn ending-bar-repeat []
  [:g
   [:rect {:x      62.5
           :y      8
           :width  1
           :height 28
           :ry     0
           :fill   "black"}]
   [:line {:x1           61.8
           :x2           61.8
           :y1           8
           :y2           36
           :stroke       "black"
           :stroke-width 0.35}]
   [:circle {:cx 60.8
             :cy 11
             :r  0.4}]
   [:circle {:cx 60.8
             :cy 13
             :r  0.4}]
   [:circle {:cx 60.8
             :cy 23
             :r  0.4}]
   [:circle {:cx 60.8
             :cy 25
             :r  0.4}]
   [:circle {:cx 60.8
             :cy 33
             :r  0.4}]
   [:circle {:cx 60.8
             :cy 35
             :r  0.4}]])

(defn eighth-note-flag [x y]
  [:path {:transform (str "scale("
                          (if (or (< 11 y 18) (< 23 y))
                            "0.1)" "0.1,-0.1)")
                          "translate("
                          (if (or (< 11 y 18) (< 23 y))
                            24 2) ","
                          (if (or (< 11 y 18) (< 23 y))
                            -61 -57) ")")
          :d         "M1-8v15h-1v-15h1zM1-8c0 12 12 19 12 31 0 4-1 8-2 12 0 0-1 1-1 1-1 0-2-1-1-2 2-4 2-7 2-11 0-6-6-12-10-16v-15z"}])

(defn beam []
  [:polygon {:points "2981,475 3499,424 3499,484 2981,535"}])

(defn kill-note []
  [:path {:d              "M 0.75,0.3 L 1.75,-0.7 M 1.75,0.3 L 0.75,-0.7"
          :stroke         "red"
          :stroke-linecap "round"
          :stroke-width   0.35}])

(defn drum-hit [duration [x y]]
  (let [mouseover? (r/atom false)]
    (fn [color [x y]]
      [:g {:on-mouse-over #(reset! mouseover? true)
           :on-mouse-out  #(reset! mouseover? false)
           ;:on-click      #(dispatch [:remove-note x y])
           :transform     (str "translate(" (+ 12.78 (* 6 x)) "," (inc y) ") ")}
       [:path {:d    "m1.24.27 .9.74c.02.01 .04.03 .07.03 .02 0 .05-.01.08-.03l.15-.12c.02-.02.04-.06.04-.09 0-.03-.02-.06-.04-.08L1.56 0 2.43-.71c.02-.02.04-.05.04-.08 0-.03-.02-.07-.04-.09l-.15-.12c-.02-.01-.05-.03-.08-.03-.02 0-.04.01-.07.03L1.24-.27.33-1.01c-.02-.01-.04-.03-.07-.03-.02 0-.05.01-.08.03l-.15.12c-.02.02-.04.06-.04.09 0 .03.02 .06.04 .08L.91 0 .04.71c-.02.02-.04.05-.04.08 0 .03.02 .07.04 .09l.15.12c.02.01 .05.03 .08.03 .02 0 .04-.01.07-.03z"
               :fill "black"}]
       [:rect {:x      (if (< 31 y)
                         2.2 0)
               :y      (if (< 31 y)
                         -6.3
                         0.8)
               :height 5.5
               :width  0.25
               :fill   "black"}]
       (if @mouseover?
         [kill-note])])))

(defn ledger-line [[x y]]
  [:rect {:transform (str "scale (1,1) translate(" (+ 8.875 (* 6.9 x)) "," (- 25.0375 y) ") ")
          :height    0.2
          :width     2.085
          :ry        0.1
          :x         x
          :y         y}])

(defn note [value [x y]]
  (let [mouseover? (r/atom false)]
    (fn [value [x y]]
      [:g {:on-mouse-over #(reset! mouseover? true)
           :on-mouse-out  #(reset! mouseover? false)
           ;:on-click      #(dispatch [:remove-note x y])
           :transform     (str "translate(" (+ 13 (* 6 x)) "," (inc y) ") ")}
       [:path {:d    "m1.62-1.06c.41 0 .8.21 .8.67 0 .53-.41.89-.76 1.1-.27.16-.56.27-.86.27-.41 0-.8-.21-.8-.67 0-.53.41-.89.76-1.1.27-.16.56-.27.86-.27z"
               :fill "black"}]
       [:rect {:x      (if (or (< 11 y 18) (< 23 y))
                         2.15 0.02)
               :y      (if (or (< 11 y 18) (< 23 y))
                         -7.1 0)
               :height 6.794
               :width  0.25
               :fill   "black"}]
       (if (or (= y 1)
               (= y 3)
               (= y 5)
               (= y 17)
               (= y 29))
         [:rect {:transform "scale (1.75,1.75)"
                 :height    0.2
                 :width     2.085
                 :ry        0.1
                 :x         -0.334
                 :y         -0.1}]
         (if (= value 0.5)
           [eighth-note-flag x y]))
       (if @mouseover?
         [kill-note])])))

(defn drum-clef []
  [:path {:transform "translate(3.75,31.334)"
          :d         "M2.5-1.3h-.7c0 0-.1 0-.1.1v3.7c0 0 0 .1.1 .1h.7c0 0 .1 0 .1-.1v-3.7c0 0 0-.1-.1-.1zM.8-1.3h-.7c0 0-.1 0-.1.1v3.7c0 0 0 .1.1 .1h.7c0 0 .1 0 .1-.1v-3.7c0 0 0-.1-.1-.1z"
          :fill      "black"}])

(defn bass-clef [x y]
  (fn []
    [:path {:transform (str "translate(" x "," y ")")
            :d         "M.187 6.323H0V6.244 6.165H.094.187V6.072 5.978H.467.747v-.094-.094h.187.187v-.094-.094h.094.094v-.094-.094h.094.094v-.094-.094h.187.187v-.094-.094h.094.094v-.094-.094h.094.094v-.094-.094h.094.094v-.187-.187h.094.094v-.094-.094h.094.094v-.187-.187h.094.094V3.456 3.176h.094.094V2.428 1.681H3.083 2.989V1.308.934H2.896 2.802V.841.747H2.709 2.616V.654.56H2.523 2.428V.467.373H1.868 1.308V.467.56H1.121.934V.654.747H.841.747V.934 1.121H1.215 1.681v.094.094h.094.094v.56.56h-.094-.094v.094.094H1.121.56V2.523 2.428H.467.373V2.241 2.055H.28.187V1.681 1.308H.28.373V1.028.747H.467.56V.654.56H.654.747V.467.373H.841.934V.28.187H1.121 1.308V.094 0H1.961 2.616V.094.187h.28.28v.094.094h.094.094v.094.094h.094.094v.094.094h.094.094v.094.094h.094.094v.187.187h.094.094v.934.934h-.094-.094v.187.187h-.094-.094v.187.187h-.094-.094v.187.187h-.094-.094v.094.094h-.094-.094v.094.094h-.094-.094v.094.094h-.094-.094v.094.094h-.094-.094v.094.094h-.187-.187v.094.094h-.094-.094v.094.094h-.187-.187v.094.094H1.495 1.308v.094.094H1.121.934v.094.094H.654.373v.079.079z
                 M4.844 1.721H4.588V1.636 1.551H4.503 4.418V1.295 1.038h.086.086V.953.868h.256.256v.086.086h.086.086V1.295 1.551h-.086-.086v.086.086z
                 M4.801 3.289H4.548V3.205 3.12H4.463 4.378V2.867 2.613h.085.085V2.529 2.445h.252.252v.085.085h.085.085V2.867 3.12h-.085-.085v.085.085z"}]))

(defn treble-clef [x y]
  [:path {:transform (str "translate(" x "," y ")")
          :d         "M2.214 12.37H1.55v-.097-.097h-.221-.221v-.111-.111h-.111-.111v-.553-.553h.111.111v-.111-.111h.111.111v-.111-.111h.332.332v.111.111h.111.111v.111.111h.111.111v.332.332h-.111-.111v.111.111h-.111-.111v.111.111h.443.443v-.111-.111h.111.111v-.996-.996h-.111-.111v-.111-.111H2.214 1.55v-.111-.111h-.221-.221v-.111-.111h-.111-.111v-.111-.111h-.111-.111v-.111-.111h-.111-.111v-.111-.111H.332.221v-.221-.221H.111 0v-.996-.996h.111.111v-.221-.221h.111.111v-.221-.221h.111.111v-.111-.111h.111.111v-.111-.111h.111.111v-.111-.111h.111.111v-.111-.111h.111.111v-.111-.111h.111.111V3.653 3.321H1.66 1.55V2.324 1.328h.111.111V.996.664h.111.111V.443.221h.111.111V.111 0h.332.332v.111.111h.111.111v.221.221h.111.111v.332.332h.111.111v.664.664h-.111-.111v.443.443h-.111-.111v.221.221h-.111-.111v.221.221h-.111-.111v.111.111h-.111-.111v.553.553h.111.111v.111.111h.443.443v.111.111h.111.111v.111.111h.111.111v.111.111h.111.111v.221.221h.069.069v.664.664h-.069-.069v.221.221h-.111-.111v.111.111h-.111-.111v.111.111h-.221-.221v.443.443h.111.111v.775.775h-.111-.111v.221.221h-.221-.221v.097.097zM1.992 9.077h.664v-.553-.553h-.111-.111v-.553-.553h-.111-.111v.111.111h-.111-.111v.111.111h-.111-.111v.332.332h.111.111v.221.221h.221.221v.111.111H2.103 1.771v-.111-.111h-.111-.111v-.111-.111h-.111-.111v-.221-.221h-.111-.111v-.332-.332h.111.111v-.221-.221h.111.111v-.111-.111h.111.111v-.111-.111h.111.111v-.111-.111h.111.111v-.111-.111h-.111-.111v-.332-.332h-.111-.111v.111.111h-.111-.111v.111.111h-.111-.111v.111.111h-.111-.111v.221.221h-.111-.111v.111.111h-.111-.111v.332.332h-.111-.111v.332.332h.111.111v.332.332h.111.111v.111.111h.111.111v.111.111h.111.111v.111.111zm1.328-.221h.221v-.221-.221h.111.111v-.443-.443h-.111-.111v-.221-.221h-.221-.221v-.111-.111h-.111-.111v.553.553h.111.111v.443.443zM2.214 3.321h.221v-.221-.221h.111.111v-.111-.111h.111.111v-.221-.221h.111.111V1.66 1.107H2.767 2.435v.221.221h-.111-.111v.221.221h-.111-.111v.664.664z"}])

(defn sharp [x y]
  [:path {:transform (str "translate(" x "," (+ 0.5 y) ")")
          :d         "M.18.04V-.91l.4-.11v.95zM.98-.19.7-.11V-1.05l.28-.08v-.39l-.28.08V-2.42h-.11v1l-.4.12V-2.24h-.11v.98l-.28.08v.39l.28-.08v.95l-.28.08V.55L.08.47v.96h.11V.43l.4-.11v.94h.11V.29L.98.21Z"}])

(defn flat [x y]
  [:path {:d "m .94 1.62s-.06-1.2-.06-2c0-.32.02-.56.04-.64.08-.24.6-.68.88-.84.18-.1.36-.14.52-.14.2 0 .38.08.5.22.2.22.32.56.32.94 0 .36-.1.78-.34 1.2-.26.48-.84 1.12-1.44 1.5-.08.04-.14.06-.2.06-.18 0-.22-.2-.22-.3m-.7 1.78c.06.08.12.1.18.1s.12-.04.12-.04c.6-.34 1.08-.88 1.58-1.22 1.78-1.24 2.4-2.46 2.4-3.38 0-1.14-.88-1.86-1.8-1.92-.14 0-.28.02-.42.06-.22.06-.46.14-.68.28-.12.1-.34.28-.44.28-.04 0-.06 0-.1-.02-.14-.06-.22-.2-.22-.34.02-.44.14-5.24.14-5.64 0-.22-.18-.34-.38-.34-.28 0-.6.2-.62.56 0 0 .08 11.42.24 11.62"}])

(defn c-sharp-minor []
  [:g [sharp 6.6 8]
   [sharp 7.4 11]
   [sharp 8.2 7]
   [sharp 9 10]
   [sharp 9.8 13]
   [sharp 10.6 9]
   [sharp 11.4 12]])

(defn staff-lines []
  [:g#lines
   (doall
    (for [y (range 38)]
      ^{:key y}
      [:line {:x1               1
              :x2               63
              :y1               y
              :y2               y
              :stroke           "black"
              :stroke-width     (if (or (= y 30) (= y 18)) 0.06 0.15)
              :stroke-dasharray (if (or (= y 30) (= y 18)) 0.25)
              :visibility       (if (and (> y 7)
                                         (even? y)
                                         (< y 42)) "visible" "hidden")
              :stroke-linecap   "butt"
              :stroke-linejoin  "bevel"}]))])

(defn app []
  [:div#app
   [:svg {:width    "100%"
          :view-box "0 0 64 36"}
    [staff-lines]
    [treble-clef 3 5]
    [bass-clef 3 20]
    [drum-clef]
    [ending-bar-repeat]]])

(defn render []
  (r/render [app]
            (.getElementById js/document "root")))

(defn ^:dev/after-load start []
  (render)
  (js/console.log "start"))

(defn ^:export init []
  (js/console.log "init")
  (start))

(defn ^:dev/before-load stop []
  (js/console.log "stop"))
