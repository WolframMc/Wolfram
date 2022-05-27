package wf.wolfram.mixin;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import wf.wolfram.mixin.opcode.OpCode;
import wf.wolfram.mixin.opcode.Response;

import java.util.function.Function;
import java.util.function.Supplier;

/**
 * Базовый миксин. Используется в Bootstrap'е.
 * Часто бывает ситуация, когда для вызова метода нужно написать
 * много блоков try catch и это портит читаемость кода за счёт
 * однотипных блоков, добавляет лишнего кода. Эту проблему
 * решает TryMixin, он оборачивает переданный Function в
 * try-catch и возвращает случившееся исключение, если оно
 * есть.
 */
public class TryMixin {

    @Getter
    @Setter(value = AccessLevel.PRIVATE)
    private Response response;

    public TryMixin(Supplier supplier) {
        setResponse(this.apply(supplier));
    }

    /**
     * Применить миксин к значению
     * @param supplier Supplier
     * @return Ответ
     */
    private Response apply(Supplier supplier) {
        try {
            return new Response(OpCode.OK, null, supplier.get());
        } catch(Exception exception) {
            return new Response(OpCode.FAIL, exception, null);
        }
    }

}
