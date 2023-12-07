package hello.advanced.trace.threadlocal.code;


import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ThreadLocalService {

    private ThreadLocal<String> nameStore = new ThreadLocal<String>();

    public String logic(String name)  {

        log.info("저장 name={} -> nameStore={}",name,nameStore.get());
        nameStore.set(name);
        //저장하고 1초 정도 쉼
        sleep(1000);
        log.info("조회 nameStore={}", nameStore.get());
        //name을 저장했다가, 1초 정도 기다리고 nameStore를 조회
        return nameStore.get();
    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();;
        }
    }

}
