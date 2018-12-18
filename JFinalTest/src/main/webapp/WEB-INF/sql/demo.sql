#sql ("blogList")
  select * from t_blog order by id asc
#end

#sql ("blogGetById")
  select * from t_blog where id=?
#end

#sql ("blogBetween")
  select * from t_blog where id between ? and ?
#end
#namespace("blog")
  #sql ("blogBetweenNew")
    select * from t_blog where id>=#para(a) and id<=#para(b)
  #end
#end