### MAIN브랜치에는 아무것도 두지 않는 걸로하고 브랜치를 파서 거기다가 푸시하기!!

#### Type: 커밋의 종류

- feat: 새로운 기능 추가
- fix: 버그 수정
- docs: 문서 수정
- style: 코드 포맷팅, 세미콜론 누락, 코드 변경이 없는 경우
- refactor: 코드 리팩토링
- test: 테스트 코드, 리팩토링 테스트 코드 추가
- chore: 빌드 업무 수정, 패키지 매니저 수정


저장소 이름:

일반적으로 프로젝트의 목적을 나타내는 이름을 사용합니다.
예: user-management-service, payment-processing-api

파일 네이밍:

클래스: PascalCase (예: UserController.java, PaymentService.java)
인터페이스: PascalCase, 'I' 접두사 사용 가능 (예: UserRepository.java 또는 IUserRepository.java)
테스트: 테스트 대상 클래스 이름 + "Test" (예: UserControllerTest.java)


변수 및 메소드 네이밍:

변수: camelCase (예: userId, paymentAmount)
메소드: camelCase, 동사로 시작 (예: getUserById(), processPayment())
상수: UPPER_SNAKE_CASE (예: MAX_RETRY_COUNT, API_BASE_URL)


패키지 네이밍:

모두 소문자 사용 (예: com.company.project.controllers)


데이터베이스 관련:

테이블 이름: snake_case, 복수형 (예: users, payment_transactions)
컬럼 이름: snake_case (예: user_id, created_at)


API 엔드포인트:

RESTful 규칙 따르기 (예: /api/v1/users, /api/v1/payments)
버전 관리 포함 (v1, v2 등)


설정 파일:

환경별 설정 파일 사용 (예: application-dev.properties, application-prod.properties)
