package com.functionaljoo.base;

import com.functionaljoo.base.annotations.Beta;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Supplier;
import org.derive4j.ArgOption;
import org.derive4j.Data;

/**
 * Missing new class name and Javadoc
 *
 * @author Renato
 *
 * @param <L>
 * @param <R>
 */
@Beta
@Data(arguments = ArgOption.checkedNotNull)
public abstract class Either2<L, R> {

    public abstract <X> X match(Supplier<X> nothing, Function<L, X> left, Function<R, X> right);
  // implements all methods from primitives generated in Either2s and/or the match method

    private final L left;
    private final R right;

    Either2() {
        this.left = null;
        this.right = null;
    }

    public static <L, R> Optional<Either2<L, R>> options(L left, R right) {
        if (left != null && right == null) {
            return Optional.of(Either2s.left(left));
        } else if (right != null) {
            return Optional.of(Either2s.right(right));
        } else {
            return Optional.empty();
        }
    }

    public <V> Optional<V> foldOptional(final Function<? super L, V> ifLeft,
            final Function<? super R,  V> ifRight) {
        if (left != null) {
            return Optional.ofNullable(ifLeft.apply((L) left));
        } else if (right != null) {
            return Optional.ofNullable(ifRight.apply((R) right));
        } else {
            return Optional.empty();
        }
    }

    public <X,Y> Either2<X,Y> bimap(java.util.function.Function<? super L,? extends X> leftMapper,
                        java.util.function.Function<? super R,? extends Y> rightMapper) {

        if (left != null) {
            X x = leftMapper.apply(left);
            return Either2s.left(x);
        }

        if (right != null) {
            Y y = rightMapper.apply(right);
            return Either2s.right(y);
        }

        return Either2s.nothing();
    }

    public <L, R> Either2<L, R> flatBimap(
            java.util.function.Function<? super L,? extends L> leftMapper,
            java.util.function.Function<? super R,? extends R> rightMapper) {

         if (left != null) {
             // L applyL = (L) left;
             L applyL = leftMapper.apply((L) left);
             return Either2s.left(applyL);
         }


         if (right != null) {
            // R applyR = (R) right;
            R applyR = rightMapper.apply((R) right);
            return Either2s.right(applyR);
         }

        return Either2s.nothing();
    }

    public <V> V fold(final Function<? super L, V> ifLeft,
            final Function<? super R,  V> ifRight,
            Supplier<V> ifNothing) {
        Optional<L> oLeft = Optional.<L>ofNullable(left);
        Optional<R> oRight = Optional.<R>ofNullable(right);
        if (oLeft.isPresent()) {
            return ifLeft.apply((L) left);
        } else if (oRight.isPresent()) {
            return ifRight.apply((R) right);
        } else {
            return ifNothing.get();
        }
    }

    public Optional<L> left() {
        return Optional.ofNullable(left);
    }

    public Optional<R> right() {
        return Optional.ofNullable(right);
    }

}