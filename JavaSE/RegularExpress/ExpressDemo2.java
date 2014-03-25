//ÈÏÊ¶
//\d--Êý×Ö
// \s--¿Õ°××Ö·û
p("hello sir".matches("^h.*"));
"hello sir".matches("^h[a-z]{1, 3}o\\b.*");
//white lines
p(" \n".matches("^[\\s&&[^\\n]]*\\n$"));
//Æ¥Åäemail

p("1445632043@qq.com".matches("[0,9]+\\@[a-z]+\\.[a-z]+"));
p("fadjkal@fdjk.com".matches("[\\w[.-]]+@[\\w[.-]]+\\.[\\w]+"));