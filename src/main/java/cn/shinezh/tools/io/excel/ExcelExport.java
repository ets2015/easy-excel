package cn.shinezh.tools.io.excel;

import java.util.List;

/**
 *
 * @author Shinez
 * @date 2017/10/19
 */
public interface ExcelExport<T> {

    /**
     * 参数obj告诉了本类如何将其解析为一个字符串的集合（即Excel的一行）
     *
     * @param obj 泛型T的一个实例
     * @return 一行（多个单元格）的值的集合
     * @throws NoSuchFieldException
     * @throws IllegalAccessException
     */
    List<String> getColumns(T obj) throws NoSuchFieldException, IllegalAccessException;

}
