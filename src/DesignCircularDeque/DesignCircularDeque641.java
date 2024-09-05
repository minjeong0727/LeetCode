package DesignCircularDeque;

public class DesignCircularDeque641 {
        //이중연결 리스트로 사용할 클래스 선언
        static class DoublyLinkedList{
            //왼쪽으로 연결할 이중 연결 리스트
            DoublyLinkedList left;

            //오른쪽으로 연결할 이중 연결 리스트
            DoublyLinkedList right;
            int val;

            public DoublyLinkedList(int val){
                this.val = val;
            }
        }
        int len;//현재 큐의 크기
        int k;//전체 큐의 크기
        DoublyLinkedList head;//이중 연결 리스트 head노드
        DoublyLinkedList tail;//이중 연결리스트 tail노드

        public DesignCircularDeque641(int k) {
            //이중 연결 리스트 2개 생성
            head = new DoublyLinkedList(0);
            tail = new DoublyLinkedList(0);
            //서로 연결
            head.right = tail;
            tail.left = head;
            //전체 큐의 크기 지정
            this.k = k;
            //현재 큐의 크기 지정
            this.len = 0;
        }

        public boolean insertFront(int value) {
            //꽉 차 있으면 진행하지 않음
            if(isFull())return false;
            DoublyLinkedList node = new DoublyLinkedList(value);
            //신규 노드는 head 바로 오른쪽에 삽입
            node.right = head.right;
            node.left = head;
            head.right.left = node;
            head.right = node;
            len++;
            return true;
        }

        public boolean insertLast(int value) {
            //꽉 차 있으면 진행하지 않음
            if(isFull())return false;
            DoublyLinkedList node = new DoublyLinkedList(value);
            //신규 노드는 tail바로 왼쪽에 삽입
            node.left = tail.left;
            node.right = tail;
            tail.left.right = node;
            tail.left = node;
            len++;
            return true;
        }

        public boolean deleteFront() {
            //텅 비어 있다면 진행하지 않음
            if(isEmpty())return false;
            //head 바로 오른쪽 노드를 연결해서 끊음
            head.right.right.left = head;
            head.right = head.right.right;
            len--;
            return true;
        }

        public boolean deleteLast() {
            //텅 비어 있다면 진행하지 않음
            if(isEmpty())return false;
            //tail바로 왼쪽 노드를 연결에서 끊음
            tail.left.left.right = tail;
            tail.left = tail.left.left;
            len--;
            return true;
        }

        public int getFront() {
            //맨 앞(head오른쪽)의 값을 가져온다.
            return (isEmpty()) ? -1 : head.right.val;
        }

        public int getRear() {
            //맨 뒤 (tail왼쪽)의 값을 가져온다.
            return (isEmpty())?-1:tail.left.val;
        }

        public boolean isEmpty() {
            //현재 큐의 크기가 0이면 비어 있음
            return len ==0;
        }

        public boolean isFull() {
            //현재 큐의 크기가 처음 선언한 큐의 크기와 일치하면 꽉 차 있음
            return len == k;
        }
    }

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */

// 책을 보고 구현했다....잘 이해가 가지 않는다...추후 업뎃(수정)예정)