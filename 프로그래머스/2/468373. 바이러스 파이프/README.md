# [level 2] 바이러스 파이프 - 468373 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/468373) 

### 성능 요약

메모리: 78.6 MB, 시간: 13.79 ms

### 구분

코딩테스트 연습 > 2025 카카오 하반기 1차

### 채점결과

정확성: 100.0<br/>합계: 100.0 / 100.0

### 제출 일자

2026년 06월 12일 16:58:50

### 문제 설명

<p><code>1</code>번부터 <code>n</code>번까지 번호가 붙은 <code>n</code>개의 배양체를 <code>n-1</code>개의 파이프로 이어 하나의 트리 모양을 만들었습니다. 각 파이프는 <code>A</code>,<code>B</code>,<code>C</code> 3개의 종류 중 하나로 초기에 모든 파이프는 닫혀있습니다.</p>

<p>배양체 중 하나가 바이러스에 감염되어 있습니다. 바이러스에 감염된 배양체는 열린 파이프를 통해 연결된 다른 인접한 배양체를 감염시킵니다.</p>

<p>당신은 종류가 같은 파이프를 한꺼번에 모두 열었다가 닫을 수 있습니다. 단, 한 종류의 파이프를 연 후 다시 닫기 전에 다른 종류의 파이프를 열 수 없습니다. 파이프를 열었다 닫는 행동을 최대 <code>k</code>번 반복해 최대한 많은 배양체에 바이러스를 감염시키려고 합니다.</p>

<p>배양체의 개수를 나타내는 정수 <code>n</code>, 감염된 배양체의 노드 번호를 나타내는 정수 <code>infection</code>, 파이프의 정보를 나타내는 2차원 정수 배열 <code>edges</code>, 최대 행동 수를 나타내는 정수 <code>k</code>가 매개변수로 주어집니다. 최대 <code>k</code>번 파이프를 열었다 닫은 후, 감염된 배양체 개수의 최댓값을 return 하도록 solution 함수를 완성해 주세요.</p>

<hr>

<h5>제한사항</h5>

<ul>
<li>2 ≤ <code>n</code> ≤ 100</li>
<li>1 ≤ <code>infection</code> ≤ <code>n</code></li>
<li><code>edges</code>의 길이 = <code>n-1</code>

<ul>
<li><code>edges[i]</code>는 [<code>x</code>, <code>y</code>, <code>type</code>]의 형태로 <code>x</code>번 노드의 배양체와 <code>y</code>번 노드의 배양체 사이가 <code>type</code> 종류의 파이프로 연결되어 있음을 의미합니다.</li>
<li>1 ≤ <code>x</code> &lt; <code>y</code> ≤ <code>n</code></li>
<li>1 ≤ <code>type</code> ≤ 3</li>
<li>1은 <code>A</code>, 2는 <code>B</code>, 3은 <code>C</code> 를 나타냅니다.</li>
</ul></li>
<li>1 ≤ <code>k</code> ≤ 10</li>
</ul>

<hr>

<h5>테스트 케이스 구성 안내</h5>

<p>아래는 테스트 케이스 구성을 나타냅니다. 각 그룹 내의 테스트 케이스를 모두 통과하면 해당 그룹에 할당된 점수를 획득할 수 있습니다.</p>
<table class="table">
        <thead><tr>
<th>그룹</th>
<th>총점</th>
<th>테스트 케이스 그룹 설명</th>
</tr>
</thead>
        <tbody><tr>
<td>#1</td>
<td>10%</td>
<td>트리가 일렬 모양입니다. 즉, 각 배양체에 연결된 파이프는 1개 혹은 2개입니다.</td>
</tr>
<tr>
<td>#2</td>
<td>20%</td>
<td>파이프의 type은 A 혹은 B만 주어집니다.</td>
</tr>
<tr>
<td>#3</td>
<td>30%</td>
<td>한 배양체에 연결된 파이프의 type이 모두 다릅니다.</td>
</tr>
<tr>
<td>#4</td>
<td>40%</td>
<td>추가 제한 사항 없음</td>
</tr>
</tbody>
      </table>
<hr>

<h5>입출력 예</h5>
<table class="table">
        <thead><tr>
<th>n</th>
<th>infection</th>
<th>edges</th>
<th>k</th>
<th>result</th>
</tr>
</thead>
        <tbody><tr>
<td>10</td>
<td>1</td>
<td>[[1, 2, 1], [1, 3, 1], [1, 4, 3], [1, 5, 2], [5, 6, 1], [5, 7, 1], [2, 8, 3], [2, 9, 2], [9, 10, 1]]</td>
<td>2</td>
<td>6</td>
</tr>
<tr>
<td>7</td>
<td>6</td>
<td>[[1, 2, 3], [1, 4, 3], [4, 5, 1], [5, 6, 1], [3, 6, 2], [3, 7, 2]]</td>
<td>3</td>
<td>7</td>
</tr>
</tbody>
      </table>
<h5>입출력 예 설명</h5>

<p><strong>입출력 예 #1</strong></p>

<p>트리가 아래 그림과 같이 구성되어 있습니다.</p>

<p><img src="https://grepp-programmers.s3.ap-northeast-2.amazonaws.com/production/presigned_urls/c0591d0d-76ae-474a-971e-7bd330d3472a/pipe_1.jpg" title="" alt="pipe_1.jpg"></p>

<p>B 타입 파이프를 열었다 닫은 후, A 타입 파이프를 열었다 닫으면 감염된 배양체가 총 6개가 됩니다.</p>

<p>1. B 타입 파이프 열림 : [1 - 5, 2 - 9]를 연결하는 파이프가 열립니다. 배양체 #5가 감염됩니다.<br>
2. B 타입 파이프 닫힘<br>
3. A 타입 파이프 열림 : [1 - 2, 1 - 3, 5 - 6, 5 - 7, 9 - 10]을 연결하는 파이프가 열립니다. 배양체 #2, #3, #6, #7이 감염됩니다.<br>
4. A 타입 파이프 닫힘<br>
5. 최종적으로 감염된 배양체는 #1, #2, #3, #5, #6, #7입니다.</p>

<p>2번의 행동으로 감염된 배양체가 6개보다 많아지는 방법은 없습니다. 따라서 6을 return 해야 합니다.</p>

<p><strong>입출력 예 #2</strong></p>

<p>트리가 아래 그림과 같이 구성되어 있습니다.</p>

<p><img src="https://grepp-programmers.s3.ap-northeast-2.amazonaws.com/production/presigned_urls/3ae182c4-3b4e-446f-97a6-cc3b849a7748/pipe_2.jpg" title="" alt="pipe_2.jpg"></p>

<p>ABC 혹은 ACB 혹은 BAC 순으로 파이프를 열었다 닫으면 감염된 배양체가 총 7개가 됩니다.<br>
3번의 행동으로 감염된 배양체가 7개보다 많아지는 방법은 없습니다. 따라서 7을 return 해야 합니다.</p>


> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges