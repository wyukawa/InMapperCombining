set hive.exec.compress.intermediate=true;
set hive.exec.compress.output=true;
set mapred.output.compression.type=BLOCK;
set mapred.output.compression.codec=org.apache.hadoop.io.compress.GzipCodec;

INSERT OVERWRITE TABLE postdata_rcfile
SELECT
  *
FROM
  postdata
;

