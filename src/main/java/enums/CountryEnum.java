package enums;

import lombok.Getter;

/**
 * Date: 2021/4/30 21:44
 * 可以用于条件判断 优化了复杂的if 判断，枚举类自身有循环的遍历每个元素，这样就不会写死代码，只需修改枚举中的属性
 * 枚举相当于数据库，每一个实例就是一个表，属性是字段中的值
 * CountryEnum  === 库
 * ONE          === 表
 * id    name
 *  1     齐
 */
public enum CountryEnum {
    ONE(1,"齐"),TWO(2,"楚"),THREE(3,"燕"),FOUR(4,"韩"),FIVE(5,"赵"),SIX(6,"魏");

    CountryEnum(Integer retCode, String retMessage) {
        this.retCode = retCode;
        this.retMessage = retMessage;
    }

    @Getter private Integer retCode;
    @Getter private String retMessage;

    public static CountryEnum forEach_CountryEnum(int index) {
        CountryEnum[] countEnums = CountryEnum.values();
        for (CountryEnum element : countEnums) {
            if (index == element.retCode){
                return element;
            }
        }
        return null;
    }
}
