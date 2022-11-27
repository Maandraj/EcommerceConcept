package com.maandraj.core.domain

interface UseCase {

    interface Out<out Output> : UseCase {
        suspend operator fun invoke(): Output
    }

}
