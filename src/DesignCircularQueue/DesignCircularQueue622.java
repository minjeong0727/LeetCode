package DesignCircularQueue;

public class DesignCircularQueue622 {
    class MyCircularQueue {
        int[]q;
        int front = 0, rear= -1, len = 0;
        public MyCircularQueue(int k) {
            //k크기의 원형 큐로 사용할 배열 선언
            this.q = new int[k];
        }

        public boolean enQueue(int value) {
            //꽉 차 있지 않다면 삽입 진행
            if(!this.isFull()){
                //rear포인터 한 칸 앞으로 이동, 최대 크기를 초과하면 나머지 위치로 이동
                this.rear = (this.rear + 1)%this.q.length;
                //rear위치에 값 삽입
                this.q[rear] = value;
                //현재 큐의 크기 계산
                this.len++;
                return true;
            }else
                return false;
        }

        public boolean deQueue() {
            //텅 비어 잇지 않다면 삭제 진행
            if(!this.isEmpty()){
                //front포인터 한 칸 앞으로 이동, 최대 크기를 초과하면 나머지 위치로 이동
                this.front = (this.front + 1) % this.q.length;
                //현재 큐의 크기 계산
                this.len--;
                return true;
            }else
                return false;
        }

        public int Front() {
            //맨 앞의 값을 가져온다.
            return (this.isEmpty())? - 1 : this.q[this.front];
        }

        public int Rear() {
            //맨 뒤의 값을 가져온다.
            return(this.isEmpty()?-1:this.q[this.rear]);
        }

        public boolean isEmpty() {
            //현재 큐의 크기가 0이면 비어있음
            return this.len == 0;
        }

        public boolean isFull() {
            //현재 큐의 크기가 전체 큐의 크기와 일치하면 꽉 차 있음
            return this.len == this.q.length;
        }
    }

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
}
