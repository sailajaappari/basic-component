(ns basic-component.core
    (:require [reagent.core :as reagent]))

;;Reagent basic component

#_(defn foo []
  "Form-3"
  (reagent/create-class {:reagent-render (fn []
                                           [:div "Hello world"])}))
#_(defn bar []
  "Form-2"
  (fn []
    [:div "Hello world"]))

#_(defn baz []
  "Form-1"
  [:div "Hello world"])

#_(defn home []
  "basic component reagent"
  [:div
   [foo]
   [bar]
   [baz]])

;;Component-level state

#_(defn foo [] 
  "Form-2 function that returns function" 
  (let [count (atom 0)] 
    (fn []  
      [:div 
       [:p {:style {:color "blue"}} "Reagent Form-2"]
       [:p "Current count is: " @count]
       [:button {:on-click #(swap! count inc)} "Increment"]])))


#_(defn bar
  "Form-1"
  []
  (let [state-component (reagent/atom {:count 0})]
    [:div 
     [:p {:style {:color "red"}} "Reagent Form-1"]
     [:p "Current count is: " (get @state-component :count)]
     [:button {:on-click #(swap! state-component update-in [:count] inc)} "Increment"]]))

#_(defn home []
  [:div
   [foo]
   [bar]])

;;add two numbers using Form-2 reagent

#_(defn add [a b]
  (let [x (js/parseFloat (.-value a))
        y (js/parseFloat (.-value b))
        s (js/document.getElementById "res")]
     (set! (.-innerHTML s) (+ x y))))
#_(defn home[]
  (fn [] 
    [:div
     [:input {:type "text"
              :id "num1"
              :size 5}]
     [:input {:type "text"
              :id "num2"
              :size 5}]
     [:button {:on-click #(add (js/document.getElementById "num1") (js/document.getElementById "num2"))} "Addition"]
     [:div {:id "res"}]])) 


;;function returns function(form-2)
(defn home []
  (let [value (reagent/atom "hai")]
     (fn []
       [:div 
        [:div  "changed value: " @value]
        [:input {:type "text"
                 :value @value
                 :on-change #(reset! value (-> % .-target .-value))}]]))) ;;(-> % .-target .-value)=(.-value (.-target %))



   

(defn  main []
  (reagent/render [home]
                  (.getElementById js/document "app")))
(main)

