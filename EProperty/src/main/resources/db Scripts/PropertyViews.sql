function(doc,meta){
if(meta.type=="json" && doc.type){
if(doc.type=="Category"){
emit(doc.id,doc.title);
}}}