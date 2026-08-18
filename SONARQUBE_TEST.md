# SonarQube Issue Demo

SonarQube의 정적 분석 결과를 확인하기 위해 **의도적으로 품질 문제와 보안상 안전하지 않은 코드**를 포함한 Java 21 예제입니다.
실서비스 코드에 복사하지 마세요.

## 포함된 분석 대상

- `BugExamples`: 확정적인 null 역참조, 0으로 나누기, 무한 재귀
- `CodeSmellExamples`: 사용하지 않는 필드/지역 변수, 빈 메서드, 중복 문자열, 표준 출력 사용, 높은 인지 복잡도
- `SecurityExamples`: 하드코딩된 비밀번호, SQL Injection, 약한 해시, 보안 토큰에 부적절한 난수, 경로 순회 가능성

SonarQube의 버전, Quality Profile, Edition에 따라 이슈의 종류와 개수는 달라질 수 있습니다. 특히 사용자 입력 흐름을 추적하는 일부 보안 규칙은 Developer Edition 이상에서 더 잘 탐지됩니다.

## 컴파일 확인

Maven이 설치된 환경에서는 다음 명령을 실행합니다.

```powershell
mvn clean verify
```

Maven 없이 JDK만 있다면 다음과 같이 확인할 수 있습니다.

```powershell
New-Item -ItemType Directory -Force target/classes | Out-Null
javac -d target/classes (Get-ChildItem -Recurse src/main/java/*.java)
```

## SonarQube 분석

SonarScanner CLI가 설치되어 있고 SonarQube 서버가 `http://localhost:9000`에서 실행 중이라고 가정합니다.

```powershell
New-Item -ItemType Directory -Force target/classes | Out-Null
javac -d target/classes (Get-ChildItem -Recurse src/main/java/*.java)
$env:SONAR_TOKEN = "<발급받은 토큰>"
sonar-scanner -Dsonar.token=$env:SONAR_TOKEN
```

## 네 번째 분석: dev 브랜치 Pull Request

버전 `4.0`에서는 버전 3.0의 일부 결점을 수정하고 `Version4IssueExamples`와
`Version4SecurityExamples`에 새로운 결점을 추가했습니다. `dev` 브랜치를 커밋하고
Pull Request를 생성한 뒤 CI에서 분석하면 PR의 New Code 기준으로 신규 이슈를 확인할
수 있습니다.

CI가 Pull Request 정보를 자동으로 인식하지 않는 환경에서는 다음 값을 전달합니다.
PR 분석 기능은 사용하는 SonarQube Edition에 따라 제공 여부가 다를 수 있습니다.

```powershell
sonar-scanner `
  -Dsonar.token=$env:SONAR_TOKEN `
  -Dsonar.pullrequest.key=<PR번호> `
  -Dsonar.pullrequest.branch=dev `
  -Dsonar.pullrequest.base=main
```

PR 분석은 변경 코드의 이슈 확인에 사용하고, 전체 프로젝트 Activity 히스토리는 PR을
병합한 뒤 대상 브랜치를 다시 분석하여 기록합니다.

## 세 번째 분석: 수정된 이슈와 새 이슈 비교

버전 `3.0`에서는 기존 null 역참조, 0 나누기, 문자열 참조 비교, 미종료
`BufferedReader` 등을 수정했습니다. 동시에 `Version3CodeSmellExamples`와
`Version3SecurityExamples`에 새로운 유지보수·보안 이슈를 추가했습니다.

버전 `2.0` 분석이 완료된 뒤 같은 프로젝트 키로 다시 스캔하면 다음 항목을 비교할 수 있습니다.

- 수정된 기존 이슈: `Resolved Issues`
- 버전 3.0에서 추가된 이슈: `New Issues`
- 계속 남겨둔 기존 결점: 전체 `Issues`

서버 주소가 다르면 다음 옵션을 추가합니다.

```powershell
sonar-scanner -Dsonar.host.url=http://<서버주소>:9000 -Dsonar.token=$env:SONAR_TOKEN
```

분석 후 SonarQube에서 프로젝트 키 `ito-agents-demo`를 조회하면 됩니다.

## 두 번째 분석과 히스토리 확인

현재 소스에는 버전 `2.0`에서 추가된 `RegressionIssueExamples`와
`SecurityRegressionExamples`가 포함되어 있습니다. 프로젝트 키는 기존과 동일하므로,
버전 `1.0`을 먼저 분석한 상태에서 다시 스캔하면 SonarQube의 Activity에서 두 번째
분석 기록과 새로 추가된 이슈를 확인할 수 있습니다.

```powershell
New-Item -ItemType Directory -Force target/classes | Out-Null
javac -d target/classes (Get-ChildItem -Recurse src/main/java/*.java)
sonar-scanner -Dsonar.token=$env:SONAR_TOKEN
```
