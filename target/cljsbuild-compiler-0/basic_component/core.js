// Compiled by ClojureScript 1.7.122 {:static-fns true, :optimize-constants true}
goog.provide('basic_component.core');
goog.require('cljs.core');
goog.require('reagent.core');
basic_component.core.home = (function basic_component$core$home(){
var value = reagent.core.atom.cljs$core$IFn$_invoke$arity$1("hai");
return ((function (value){
return (function (){
return new cljs.core.PersistentVector(null, 3, 5, cljs.core.PersistentVector.EMPTY_NODE, [cljs.core.cst$kw$div,new cljs.core.PersistentVector(null, 3, 5, cljs.core.PersistentVector.EMPTY_NODE, [cljs.core.cst$kw$div,"changed value: ",(cljs.core.deref.cljs$core$IFn$_invoke$arity$1 ? cljs.core.deref.cljs$core$IFn$_invoke$arity$1(value) : cljs.core.deref.call(null,value))], null),new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [cljs.core.cst$kw$input,new cljs.core.PersistentArrayMap(null, 3, [cljs.core.cst$kw$type,"text",cljs.core.cst$kw$value,(cljs.core.deref.cljs$core$IFn$_invoke$arity$1 ? cljs.core.deref.cljs$core$IFn$_invoke$arity$1(value) : cljs.core.deref.call(null,value)),cljs.core.cst$kw$on_DASH_change,((function (value){
return (function (p1__7805_SHARP_){
var G__7808 = value;
var G__7809 = p1__7805_SHARP_.target.value;
return (cljs.core.reset_BANG_.cljs$core$IFn$_invoke$arity$2 ? cljs.core.reset_BANG_.cljs$core$IFn$_invoke$arity$2(G__7808,G__7809) : cljs.core.reset_BANG_.call(null,G__7808,G__7809));
});})(value))
], null)], null)], null);
});
;})(value))
});
basic_component.core.main = (function basic_component$core$main(){
return reagent.core.render.cljs$core$IFn$_invoke$arity$2(new cljs.core.PersistentVector(null, 1, 5, cljs.core.PersistentVector.EMPTY_NODE, [basic_component.core.home], null),document.getElementById("app"));
});
basic_component.core.main();
