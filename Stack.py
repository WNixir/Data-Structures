class StackEmptyError(Exception):
    """
    An error to be raised when someone tries to pop from an empty stack
    """


class Stack:
    def __init__(self):
        self.contents = []

    def push(self, new_object):
        self.contents.append(new_object)

    def pop(self):
        if self.is_empty():
            raise StackEmptyError("Can't pop from empty Stack!")
        else:
            ret_item = self.contents[-1]
            self.contents = self.contents[:-1]
        return ret_item

    def size(self):
        return len(self.contents)

    def peek(self):
        return self.contents[len(self.contents) - 1]

    def is_empty(self):
        return self.contents == []
