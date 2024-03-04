# 개발환경
1. IDE : IntelliJ
2. Spring Boot
3. JDK 11
4. mysql
5. Spring Data JPA
6. Thymeleaf

# 회원기능
1. 로그인 (/member/login)
2. 로그아웃 (/member/logout)
3. 회원가입 (/member/save)
4. 회원조회 (/member/{id})
5. 정보수정 (/member/update/{id})
6. 정보삭제 (/member/delete/{id})

# 게시판기능
1. 글쓰기 (/board/save)
2. 글목록 (/board/)
3. 글조회 (/board/{id})
4. 글수정 (/board/update/{id})
5. 글삭제 (/board/delete/{id})

# RESTAPI 게시판기능
1. 글쓰기 (/board/api/save) (POST)
       {
       "boardWriter": "jyj",
       "boardPass": "jyj",
       "boardTitle": "jyj",
       "boardContents": "jyj"
       }
2. 글목록 (/board/api/) (GET)
3. 글조회 (/board/api/{id}) (GET)
4. 글수정 (/board/api/update/{id}) (POST)
5. 글삭제 (/board/api/delete/{id})
