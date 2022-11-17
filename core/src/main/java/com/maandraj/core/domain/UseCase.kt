package com.maandraj.core.domain

interface UseCase {
    interface SingleIn<in Input> : UseCase {
        suspend operator fun invoke(data: Input)
    }

    interface DoubleInOut<in FirstInput, in SecondInput, out Output> : UseCase {
        suspend operator fun invoke(firstParam: FirstInput, secondParam: SecondInput): Output
    }

    interface DoubleIn<in FirstInput, in SecondInput> : UseCase {
        suspend operator fun invoke(firstParam: FirstInput, secondParam: SecondInput)
    }

    interface SingleInOut<in Input, out Output> : UseCase {
        suspend operator fun invoke(data: Input): Output
    }

    interface Out<out Output> : UseCase {
        suspend operator fun invoke(): Output
    }
}
