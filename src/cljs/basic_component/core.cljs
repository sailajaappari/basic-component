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
  (let [count (reagent/atom 0)] 
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

#_(defn add 
  [a b]
  (+ (int @a) (int @b)))
#_(defn home []
  (let [ num1 (reagent/atom 0)
         num2 (reagent/atom 0)
         result (reagent/atom 0)]
     (fn []
        [:div
         [:span
          [:input {:type "text"
                   :value @num1
                   :on-change #(reset! num1 (-> % .-target .-value))}]
          [:input {:type "text"
                   :value @num2
                   :on-change #(reset! num2 (-> % .-target .-value))}]]
         [:div
          [:p "Diff : " (- (int @num1) (int @num2))]]
         [:div
          [:button {:on-click #(reset! result (add num1 num2))} "Add"]]
         [:div
          [:p "Sum : " @result]]])))

;;function returns function(form-2)
#_(defn home []
  (let [value (reagent/atom "hai")]
     (fn []
       [:div 
        [:div  "changed value: " @value]
        [:input {:type "text"
                 :value @value
                 :on-change #(reset! value (-> % .-target .-value))}]]))) ;;(-> % .-target .-value)=(.-value (.-target %))

;;Cursors


(defn cursors []
  (let [app-state (reagent/atom {:foo {:bar "Hello, world!"
                                    :baz {:quux "Woot"}}})
        foo-cursor (reagent/cursor app-state [:foo])
        foobar-cursor (reagent/cursor app-state [:foo :bar])
        foobaz-cursor (reagent/cursor app-state [:foo :baz])
        foobazquux-cursor (reagent/cursor app-state [:foo :baz :quux])]
      [:div 
       [:div (str "Inside app-state: " @app-state)]
       [:div (str "Inside foo-cursor: " @foo-cursor)]
       [:div (str "Inside foobar-cursor: " @foobar-cursor)]
       [:div (str "Inside foobaz-cursor: " @foobaz-cursor)]
       [:div (str "Inside foobazquux-cursor: " @foobazquux-cursor)]]))

   

(defn  main []
  (reagent/render [cursors]
                  (.getElementById js/document "app")))
(main)

