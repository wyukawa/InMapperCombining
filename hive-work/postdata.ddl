CREATE TABLE IF NOT EXISTS postdata (
    chihou_code     string,
    post_code       string,
    choiki_name     string,
    choson_name     string,
    todoufuken_name string,
    flag1   int,
    flag2   int,
    flag3   int,
    flag4   int,
    flag5   int,
    flag6   int
)
ROW FORMAT DELIMITED
   FIELDS TERMINATED BY ','
;
