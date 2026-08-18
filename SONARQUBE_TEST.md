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

서버 주소가 다르면 다음 옵션을 추가합니다.

```powershell
sonar-scanner -Dsonar.host.url=http://<서버주소>:9000 -Dsonar.token=$env:SONAR_TOKEN
```

분석 후 SonarQube에서 프로젝트 키 `ito-agents-demo`를 조회하면 됩니다.
