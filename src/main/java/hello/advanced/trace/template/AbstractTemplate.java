package hello.advanced.trace.template;

import hello.advanced.trace.TraceStatus;
import hello.advanced.trace.logtrace.LogTrace;

public abstract class AbstractTemplate<T> {

    private final LogTrace trace;

    protected AbstractTemplate(LogTrace trace) {
        this.trace = trace;
    }

    public T execute(String message){
        TraceStatus status = null;
        try {
            status = trace.begin(message);
            //로직 호출
            T result = call();

            trace.end(status);
            return result;
        } catch (Exception e) {
            trace.exception(status, e);
            throw e;
        }
    }

    protected abstract T call();
}

//제네릭 T 이해를 위한 설명
//추상 템플릿 관련된 것을 생성할 때
//타입을 줄 수 있다.
//만약 AbstractTemplate<T> T부분에 String을 주면
//public T execute(String message) 의 T도 String으로 반환된다.
//타입 설정을 객체 시점으로 뒤로 미룬다는 느낌
