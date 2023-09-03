## 로그인 기능 구현

### index.jsp(홈페이지 역할) 
- 회원의 이메일과 비밀번호를 입력 가능한
    memberdb.jsp로 이동가능한 링크가 있다. 

### memberdb(로그인 정보 입력 form이 위치함)
- 이메일과 비번을 입력하고 전송 버튼을 누르면 
  index.jsp로 이동한다. 

### memberdblist(회원의 전체 목록-list을 보여줌)
- db에 저장된 member 테이블의 모든 데이터를 가져와 리스트로 출력
  
### memberdbidrow(각 회원의 id, 이메일과 비번을 볼수 있다.)
- memberdblist에서 각 id를 클릭하면
memberdbidrow 페이지로 이동해 각 회원의 이메일과
비밀번호를 확인가능하다. 
  