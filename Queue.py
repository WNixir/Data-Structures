class QueueEmptyError(Exception):
    """
    An error to be raise when trying to dequee from empty queue
    """


class Queue:
    def __init__(self):
        self.contents = []

    def is_empty(self):
        return self.contents == []

    def enqueue(self, new_object):
        self.contents.insert(0, new_object)

    def dequeue(self):
        if self.is_empty():
            raise QueueEmptyError("Can't de-queue from empty Queue!")
        else:
            return self.contents.pop()

    def size(self):
        return len(self.contents)
