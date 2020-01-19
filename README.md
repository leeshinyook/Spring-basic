# Spring Quick Start
![k782535789_1](https://user-images.githubusercontent.com/55838461/71668166-2a445400-2dab-11ea-9e15-909dfae73649.jpg)

##### spring-quick-start

`스프링 퀵 스타트, 저자 : 채규태`

위 책을 공부하면서 배운 내용을 정리했습니다.



## 실습추가내용

​	아래 실습내용은 기존 책의 내용에서 스스로 생각하여 책에 없는 내용을 추가한 것입니다.

[Model1. JSP 게시판 회원가입기능](https://github.com/leeshinyook/Spring-basic/blob/master/practice/model1JSP.md)



### 책을 읽고

- 이 책을 왜 읽었나?

  우선 무엇보다도, 스프링에 대해 궁금했다. 왜 많은 대기업들은 스프링을 사용할까? 라는 궁금증이 있었다.

  이전에 `Express`를 경험해본바 느낀점은 너무나 편리했다. 서버는 정말 몇 줄이면 구동이 가능했고, 무엇보다

  유연하고 자유로웠다. 반면에 듣기로는 스프링은 세팅이 복잡하고, 다루기 까다롭다고 한다. 그럼에도 왜 

  `Spring` 이 애용되는지에 대한 궁금증을 해소하기 위해 이 책을 읽게되었다.

  

- 프레임워크는 중요하지 않아.

  `Spring`은 프레임워크다. 이는 중요치 않다. 이 책에서는 MVC1부터 MVC2, SpringMVC 차례로

  '게시판 CRUD' 라는 프로젝트를 두고 그 패턴의 단점을 확인하면서 이를 보완해나가는 방식으로 진행된다.

  예를 들어, MVC1에서는 JavaBean이 Model기능을 수행하고, JSP가 Controller와 View의 기능을 수행

  한다. 여기서 JSP에 자바로직과, 화면디자인이 통합되어 유지보수가 어렵다는 점이다. 그래서 이를 분리하여

  Servlet이라는 Controller역할과 책임을 가진 녀석이 등장한다. 이 책에서는 왜 결론인 스프링부터 가르쳐주지 

  않았을까? 내가 생각하는 저자의 의도는 이 흐름이 중요하다는 것이다. 스프링뿐만이 아니라 여러 프레임워크는

  개발자의 편리함과 쾌적한 유지보수의 틀을 제공하는 것이다. 즉, 여러 기능의 `추상화` 를 제공하는 것 이다.

  내 생각에는 프레임워크는 자체는 중요하지 않다. 내가 어떠한 기술을 사용하여 목적을 달성하는 것보다 

  이 `추상화` 가 왜 만들어졌는지, 궁금해하고 알아가는 것이  더욱 의미가 있는 것 같다.



- 스프링의 강력함

  - IoC (Inversion of Control) 제어의 역전

    프로그램은 개발자가 흐름을 제어한다. 개발자가 이를 제어하는 주체이다. 스프링에서는 프로그램의 흐름을

    프레임워크가 주도한다. 객체의 생성과, 생명주기 관리등 컨테이너가 이 모든 것을 제어한다.

    즉, 제어권이 개발자 -> 컨테이너로 넘어가 이를 제어의 역전이라 한다.

    이 컨테이너가 제어권을 가져 DI(의존성 주입), AOP(관점 지향 프로그래밍)이 가능케 된다.

    

  - DI (Dependency Injection) 의존성 주입

    객체간의 의존성을 외부에서 주입하는 것 이다.  소스코드의 변경없이 환경설정 만으로도 프로그램을 제어할 수 있었다.

    

  - AOP (Aspect Oriented Programming) 관점 지향 프로그래밍

    어떠한 로직을 기준으로 핵심관점, 부가적 관점으로 나누어 본다. 예를 들어, 핵심 관점은 우리가 적용하고자하는

    핵심 비즈니스 로직이 된다. 부가적 로직은 핵심 로직을 실행하기 위한, (DB 연동, 로깅, 파일IO) 등이 있다.

    소스 코드상, 어떤 부분을 반복적으로 쓰는 코드들이 보인다. 이를 횡단 관심이라 이 책에서 표현하고 

    흩어진 관심사라 한다. 이를 Aspect로 모듈화 하고 핵심적인 비즈니스 로직에서 분리하여 재사용하겠다는 것이

    AOP의 목적이다.

  

