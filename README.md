### MAIN브랜치에는 아무것도 두지 않는 걸로하고 브랜치를 파서 거기다가 푸시하기!!


#### Type: 커밋의 종류

- feat: 새로운 기능 추가
- fix: 버그 수정
- docs: 문서 수정
- style: 코드 포맷팅, 세미콜론 누락, 코드 변경이 없는 경우
- refactor: 코드 리팩토링
- test: 테스트 코드, 리팩토링 테스트 코드 추가
- chore: 빌드 업무 수정, 패키지 매니저 수정

##### Subject: 커밋의 간단한 설명

현재 시제의 명령어 형태로 작성
첫 글자는 대문자로 시작
마침표로 끝내지 않음

##### Body: 커밋에 대한 상세 설명 (선택사항)

어떻게 변경했는지보다 무엇을 변경했는지, 왜 변경했는지를 설명

##### Footer: 주요 변경사항이나 Breaking Changes 등을 기술 (선택사항)

BREAKING CHANGE: API의 변경 등 크리티컬한 변경사항을 기술
Closes #123, #456: 관련된 이슈 번호를 명시

### 예시

fix(database): 사용자 정보 조회 시 발생하는 NullPointerException 수정

- 사용자 정보가 없을 경우 기본값 반환하도록 로직 변경

BREAKING CHANGE: getUserInfo() 메소드의 반환 타입이 Optional<UserInfo>로 변경됨

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
