package wf.wolfram.mixin.opcode;

/**
 * Часто, функции и миксины возвращают какие либо значения,
 * либо же вызывают исключения. Чтобы удобнее работать с этими
 * исключениями и миксинами есть Response. Он содержит в себе
 * возможное исключение, статус ответа и объект.
 */
public record Response<T>(OpCode code, Exception exception, T value) {
    public boolean ok() { return code == OpCode.OK; }
}
