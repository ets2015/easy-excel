# easy-excel
### 安装依赖
- git clone 项目
- mvn clean install
- 添加以下依赖到你的项目：
```xml
        <dependency>
            <groupId>com.shinezh</groupId>
            <artifactId>easy-excel</artifactId>
            <version>1.0.RELEASE</version>
        </dependency>
```

### 使用方法
- 导出到请求响应输出流
```java
 /**
  * 导出
  *
  * @param list 数据集合
  * @param heads 表头数组
  * @param fieldStr 字段属性头
  * @param tClass 类型对象
  * @param fileName 文件名
  * @param response 
  * @param <T>
  * @throws NoSuchFieldException
  * @throws InstantiationException
  * @throws IllegalAccessException
  * @throws IOException
  */
public static <T> void exportFromListToStream(List<T> list, String[] heads, String[] fieldStr, Class<T> tClass, String fileName, HttpServletResponse response) throws NoSuchFieldException, InstantiationException, IllegalAccessException, IOException；
```
- 导出到工作簿
```java
 /**
  * 导出Excel
  *
  * @param srcList     list集合，数据源
  * @param headNames   表头数组，定义生成的Excel的表头文字
  * @param excelExport 导出实现接口
  * @return
  */
 public static <T> HSSFWorkbook exportFromList(List<T> srcList, String[] headNames, ExcelExport<T> excelExport) throws IOException, NoSuchFieldException, IllegalAccessException;
```

- 解析Excel导入
```java
/**
 * 解析Excel导入
 *
 * @param inputStream        输入流
 * @param excelImport 导入接口
 * @return 返回对象的List集合
 * @throws IOException
 */
public static <T> List<T> importFromFile(InputStream inputStream, ExcelImport<T> excelImport) throws Exception;

/**
 * 解析Excel导入
 *
 * @param <T>
 * @param inputStream      输入流
 * @param tClass    类型对象
 * @param fieldsArr 字段名称数组
 * @return 返回对象的List集合
 */
public static <T> List<T> importFromFile(InputStream inputStream, Class<T> tClass, String... fieldsArr) throws Exception;
```

### 自定义解析规则
- 自定义导入解析
###### 实现ExcelImport<T>接口的方法：
```java
/**
 * 通过columns参数（即Excel的每一行中单元格的数据转换成字符串后的集合），解析为具体的一个对象。
 *
 * @param columns 单元格的数据转换成字符串后的集合
 * @return 该类的泛型的一个实例
 */
 List<T> getObjList(List<String> columns) throws Exception;
```
- 自定义导出解析
###### 实线ExcelExport<T>接口的方法：
```java
/**
 * 参数obj告诉了本类如何将其解析为一个字符串的集合（即Excel的一行）
 *
 * @param obj 泛型T的一个实例
 * @return 一行（多个单元格）的值的集合
 */
 List<String> getColumns(T obj) throws NoSuchFieldException, IllegalAccessException;
```


