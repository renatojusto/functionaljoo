package com.functionaljoo.base;

import java.util.Optional;
import java.util.function.Function;

/**
 * EitherOptional define dois simples métodos options e fold. Ela tem o objetivo
 * de mixar as funcionalidades da classe java.util.Optional com a Either do fugue.
 *
 * Com ela podemos definir duas simples opções e aplicar uma transformação sobre
 * o resultado para retornar um valor comum.
 *
 * @author Renato
 *
 * @param <L>
 * @param <R>
 */
public class EitherOptional<L, R> {

    private final Optional<L> left;
    private final Optional<R> right;

    private EitherOptional() {
        this.left = null;
        this.right = null;
    }

    private EitherOptional(Optional<L> left, Optional<R> right) {
        this.left = left;
        this.right = right;
    }

    public static <T, K> EitherOptional<Optional<T>, Optional<K>> options(T left, K right) {
        Optional<T> oLeft = Optional.<T>ofNullable(left);
        Optional<K> oRight = Optional.<K>ofNullable(right);
        return new EitherOptional(oLeft, oRight);
    }

//    public <V> Optional<V> toOptional() {
//        if (left.isPresent()) {
//            return (Optional<V>) left;
//        } else {
//            return (Optional<V>) right;
//        }
//    }

//    public <V> V fold(final Function<? super L, V> ifLeft, final Function<? super R, V> ifRight) {
//        if (left.isPresent()) {
//            return ifLeft.apply(left.get());
//        } else {
//            return ifRight.apply(right.get());
//        }
//    }

//    public <V> Optional<V> foldOptional(final Function<? super Optional<L>, Optional<V>> ifLeft,
//            final Function<? super  Optional<R>,  Optional<V>> ifRight) {
//        if (left.isPresent()) {
//            return ifLeft.apply(left);
//        } else {
//            return ifRight.apply(right);
//        }
//    }

//    public <V> Optional<V> foldOptional2(final Function<? super Optional<L>, V> ifLeft,
//            final Function<? super  Optional<R>,  V> ifRight) {
//        if (left.isPresent()) {
//            return Optional.ofNullable(ifLeft.apply(left));
//        } else {
//            return Optional.ofNullable(ifRight.apply(right));
//        }
//    }

    public <V> Optional<V> fold(final Function<? super L, V> ifLeft,
            final Function<? super R,  V> ifRight) {
        if (left.isPresent()) {
            return Optional.ofNullable(ifLeft.apply((L) left));
        } else if (right.isPresent()) {
            return Optional.ofNullable(ifRight.apply((R) right));
        } else {
            return Optional.empty();
        }
    }

    // public <V> EitherOptional<L, R> flatMap()
    public <X, RR extends R> EitherOptional<X, R> flatMap(final Function<? super L, EitherOptional<X, RR>> f) {
        if (left.isPresent()) {
            @SuppressWarnings("unchecked")
            final EitherOptional<X, R> result = (EitherOptional<X, R>) f.apply((L) left);
            return result;
        } else {
            return null;
        }
    }

//    public static <T> Optional<T> or(Optional<T> optional, Supplier<Optional<T>> supplier) {
//        if (optional.isPresent()) {
//            return optional;
//        } else {
//            return supplier.get();
//        }
//    }
}