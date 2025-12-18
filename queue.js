// enque = adding back
// dequere = remving front
// front = see first element
// isEmpty() size()

// 1. Queue using Array  O(n) dequeue
class Queue {
  constructor() {
    this.q = [];
  }

  enqueue(val) {
    this.q.push(val);
  }

  dequeue() {
    if (this.q.length === 0) return "Queue is Empty";
    // O(n)
    return this.q.shift();
  }

  front() {
    if (this.q.length === 0) return "Queue is Empty";
    return this.q[0];
  }

  isEmpty() {
    return this.q.length === 0;
  }

  size() {
    return this.q.length;
  }
}

const queueNormal = new Queue();

queueNormal.enqueue(10);
queueNormal.enqueue(20);
queueNormal.enqueue(30);

console.log(queueNormal.dequeue()); // 10
console.log(queueNormal.front());

// -----------------------------------------------------------------

// 2. Queue using Obejct  dequeue

class ObjectQueue {
  constructor() {
    this.q = {};
    this.rearIndex = 0;
    this.frontIndex = 0;
  }

  enqueue(val) {
    this.q[this.rearIndex] = val;
    this.rearIndex += 1;
  }

  dequeue() {
    if (this.frontIndex === this.rearIndex) return "queue is Empty";
    const firstEl = this.q[this.frontIndex];
    delete this.q[this.frontIndex];
    this.frontIndex++;
    return firstEl;
  }

  isEmpty() {
    return this.frontIndex === this.rearIndex;
  }

  size() {
    return this.rearIndex - this.frontIndex;
  }

  front() {
    if (this.rearIndex === this.front) return "queue is Empty";
    return this.q[this.frontIndex];
  }
}

const queue = new ObjectQueue();

queue.enqueue(10);
queue.enqueue(20);
queue.enqueue(30);

console.log(queue.dequeue()); // 10
console.log(queue.front());

// -----------------------------------------------------------------

// 3. Queue using Linked List

class Node {
  constructor(val) {
    this.val = val;
    this.next = null;
  }
}

class LinkQueue {
  constructor() {
    this.front = null;
    this.rear = null;
  }

  enqueue(val) {
    const newNode = new Node(val);
    if (!this.rear) {
      this.rear = this.front = newNode;
      return;
    }
    this.rear.next = newNode;
    this.rear = newNode;
    return;
  }

  dequeue() {
    if (!this.front) return null;
    const data = this.front.val;

    this.front = this.front.next;
    if (!this.front) {
      this.rear = null;
    }
    return data;
  }

  isEmpty() {
    return !this.front;
  }

  size() {
    if (!this.front) return 0;
    let temp = this.front;
    let count = 0;
    while (temp) {
      count++;
      temp = temp.next;
    }
    return count;
  }

  peek() {
    if (!this.front) return null;
    return this.front.val;
  }
}

const linkQueue = new LinkQueue();

linkQueue.enqueue(100);
linkQueue.enqueue(200);
linkQueue.enqueue(300);

console.log(linkQueue.dequeue()); // 100
console.log(linkQueue.peek());

// -----------------------------------------------------------------

// 3. Queue using Two Stack

class QueueStack {
  constructor() {
    this.s1 = [];
    this.s2 = [];
  }

  enqueue(val) {
    this.s1.push(val);
  }

  dequeue() {
    if (this.s2.length === 0) {
      while (this.s1.length) {
        this.s2.push(this.s1.pop());
      }
    }
    return this.s2.pop();
  }

  size() {
    return this.s1.length + this.s2.length;
  }

  isEmpty() {
    return this.s1.length === 0 && this.s2.length === 0;
  }

  peek() {
    if (!this.s2.length) {
      if (!this.s1.length) return null;
      while (this.s1.length) {
        this.s2.push(this.s1.pop());
      }
    }
    return this.s2[this.s2.length - 1];
  }
}

const queueStack = new QueueStack();

queueStack.enqueue(100);
queueStack.enqueue(200);
queueStack.enqueue(300);

console.log(queueStack.dequeue()); // 100
console.log(queueStack.peek());

// reverse a queue using stack

function reverseQueue(queue) {
  const s = [];
  while (queue.size) {
    s.push(queue.dequeue());
  }
  while (s.length) {
    queue.enqueue(s.pop());
  }

  return queue;
}

console.log(queueNormal);
console.log(reverseQueue(queueNormal));
