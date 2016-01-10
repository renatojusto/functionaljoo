package com.functionaljoo.base;

import com.functionaljoo.base.annotations.Beta;
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
@Beta
public class Either2<L, R> {

    private final L left;
    private final R right;

    private Either2() {
        this.left = null;
        this.right = null;
    }

    private Either2(L left, R right) {
        this.left = left;
        this.right = right;
    }


    public static <T, K> Either2<T, K> options(T left, K right) {
        return new Either2(left, right);
    }

    public <V> Optional<V> foldOptional(final Function<? super L, V> ifLeft,
            final Function<? super R,  V> ifRight) {
        Optional<L> oLeft = Optional.<L>ofNullable(left);
        Optional<R> oRight = Optional.<R>ofNullable(right);
        if (oLeft.isPresent()) {
            return Optional.ofNullable(ifLeft.apply((L) left));
        } else if (oRight.isPresent()) {
            return Optional.ofNullable(ifRight.apply((R) right));
        } else {
            return Optional.empty();
        }
    }

    public <X,Y> Either2<X,Y> bimap(java.util.function.Function<? super L,? extends X> leftMapper,
                        java.util.function.Function<? super R,? extends Y> rightMapper) {

        X x = null;
        if (Optional.ofNullable(left).isPresent()) {
            x = leftMapper.apply(left);
        }

        Y y = null;
        if (Optional.ofNullable(right).isPresent()) {
            y = rightMapper.apply(right);
        }

        return new Either2<>(x, y);
    }

    public <L, R> Either2<L, R> flatBimap(
            java.util.function.Function<? super L,? extends L> leftMapper,
            java.util.function.Function<? super R,? extends R> rightMapper) {

         Optional<L> oLeft = Optional.<L>ofNullable((L) left);

         L applyL = (L) left;

         if (oLeft.isPresent()) {
             applyL = leftMapper.apply((L) left);
         }

         Optional<R> oRight = Optional.<R>ofNullable((R) right);
         R applyR = (R) right;

         if (oRight.isPresent()) {
            applyR = rightMapper.apply((R) right);
         }

        return new Either2<>(applyL, applyR);
    }

    public <V> V fold(final Function<? super L, V> ifLeft, final Function<? super R,  V> ifRight) {
        Optional<L> oLeft = Optional.<L>ofNullable(left);
        Optional<R> oRight = Optional.<R>ofNullable(right);
        if (oLeft.isPresent()) {
            return ifLeft.apply((L) left);
        } else if (oRight.isPresent()) {
            return ifRight.apply((R) right);
        } else {
            return null;
        }
    }

    public L getLeft() {
        return left;
    }

    public R getRight() {
        return right;
    }
}