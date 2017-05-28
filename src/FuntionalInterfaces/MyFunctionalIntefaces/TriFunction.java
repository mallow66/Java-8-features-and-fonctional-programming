package FuntionalInterfaces.MyFunctionalIntefaces;

/**
 * Created by brahim on 5/28/17.
 */
@FunctionalInterface
public interface TriFunction<T,U,V,R> {

    R apply(T t, U u ,V v);

}
