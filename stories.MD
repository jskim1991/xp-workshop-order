
given: 나는 이수진이다
when: 홈화면에 접속했다
then: 각 주문의 정보를 볼 수 있다

시나리오 1: 'Orders' 제목과 ID, TOTAL PRICE 문구를 볼 수 있다
시나리오 2: 각 order의 id와 금액을 볼 수 있다

---
given: 나는 이수진이다
when: 홈화면에 하나의 order를 클릭하면
then: 주문 상세 정보를 볼 수 있다

시나리오 1: 'Order Details' 제목을 볼 수 있다
시나리오 2: 하나의 order를 클릭하면 Order Details 아래에 note를 볼 수 있다
---