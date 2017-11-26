import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.math3.ml.clustering.CentroidCluster;
import org.apache.commons.math3.ml.clustering.KMeansPlusPlusClusterer;
import org.apache.spark.SparkConf;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws ParseException, IOException {
        SparkConf conf = new SparkConf().setAppName("Java Spark SQL basic example").setMaster("local[2]");
        SparkSession spark = SparkSession
                .builder()
                .appName("Java Spark SQL basic example")
                .config(conf)
                .getOrCreate();

        Dataset<Row> df = spark.read().json("/Users/kechagiaskonstantinos/Downloads/sparkHackathon/testData.json");

        df.printSchema();

        // Register the DataFrame as a SQL temporary view
        df.createOrReplaceTempView("people");

        Dataset<Row> sqlDF = spark.sql("SELECT * FROM people");
        sqlDF.show();

        List<Row> listOne = sqlDF.collectAsList();
        List<TestDataDTO> testDataDTOList = new ArrayList<TestDataDTO>();
        SimpleDateFormat dt = new SimpleDateFormat("yyyyy-mm-dd hh:mm:ss");

        System.out.println(listOne);

        for(Row row : listOne){
            testDataDTOList.add(new TestDataDTO(dt.parse((String)row.get(0)),Boolean.parseBoolean((String)row.get(1)),(String)row.get(2),(Double)row.get(3),(Double)row.get(4),(Long)row.get(5)));
        }
        System.out.println(testDataDTOList);

        // Displays the content of the DataFrame to stdout
        df.show();

        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File("/Users/kechagiaskonstantinos/Downloads/sparkHackathon/testDataFormated.json"), testDataDTOList);





    }
}
