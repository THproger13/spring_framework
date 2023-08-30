## 스프링 기본
    
### 1. 스프링 제공 클래스
        a. InternalResourceViewResolver
            1. 컨트롤러의 String 리턴값과 동일한 jsp 파일을 열어줌

```
        <beans:property name="prefix" value="/WEB-INF/views/" /> 
        <beans:property name="suffix" value=".jsp" />
```
            2. 컨트롤러 리턴값이 "index"라면
                1. prefix + 리턴값 + suffix 형태로 만들어줌
                2. /WEB-INF/views/index.jsp

- servlet-context.xml의 base-package

   - a. 프로젝트 실행시 지정한 패키지 이하의 모든 클래스를 스캔하며
@Controller, @Service, @Repositroy,@Component 어노테이션(Anotation)이 붙은 
클래스들을 스프링 빈으로 등록해줌
  

   - b. 스프링빈 : 스프링에서 관리하는 객체로 프로젝트 실행시 객체를 1개만 갖는 
싱글톤(Singletone) 형태로 생성됨

### 2. 스프링 에러노트
    - 브라우저에서 404    
        - .XML파일 이름이 틀렸을때
        해결 : Tomcat Localhost Log에 FileNotFoundException 발생
        - Servlet-context.xml의 base-pakage이름 틀렸을때 
    - 400 Bad Request 
      - 클라이언트에서 요청한 파라마터 이름과 컨트롤러에서 받을 파라미터 이름이 다를 때