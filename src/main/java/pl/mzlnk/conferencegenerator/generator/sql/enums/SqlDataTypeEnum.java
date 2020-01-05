package pl.mzlnk.conferencegenerator.generator.sql.enums;

import lombok.Getter;

import java.util.Calendar;
import java.util.stream.Stream;

@Getter
public enum SqlDataTypeEnum {

    INT("INT", Integer.class),
    VARCHAR("VARCHAR", String.class),
    TIMESTAMP("TIMESTAMP", Calendar.class);

    private String sqlDataType;
    private Class<?> javaEquivalent;

    private SqlDataTypeEnum(String sqlDataType, Class<?> javaEquivalent) {
        this.sqlDataType = sqlDataType;
        this.javaEquivalent = javaEquivalent;
    }

    public SqlDataTypeEnum fromClass(Class<?> clazz) {
        return Stream.of(values())
                .filter(e -> e.javaEquivalent.equals(clazz))
                .findAny()
                .orElse(VARCHAR);
    }

}
