package pl.mzlnk.conferencegenerator.entity;

import lombok.NoArgsConstructor;
import pl.mzlnk.conferencegenerator.generator.annotations.PrimaryKey;

import java.lang.reflect.Field;

@NoArgsConstructor
public abstract class BaseEntity implements Identifiable {

    @Override
    public int getId() {
        Class<?> clazz = this.getClass();
        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields) {
            PrimaryKey key = field.getDeclaredAnnotation(PrimaryKey.class);
            if (key != null) {
                field.setAccessible(true);
                try {
                    int id = (int) field.get(this);
                } catch (IllegalAccessException | ClassCastException e) {
                    e.printStackTrace();
                    // todo: add log error here
                }
            }
        }
        return -1;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(this.getId());
    }

    @Override
    public boolean equals(Object object) {
        if (this == object)
            return true;

        if (object == null || object.getClass() != this.getClass())
            return false;

        Identifiable other = (Identifiable) object;

        return this.getId() == other.getId();
    }

}
