#include <iostream>
#include <vector>

using namespace std;

template <class DT>

class BST {

    protected:
    int size = 0;
    BST<DT>* left;
    BST<DT>* right;
    DT data;
    BST<DT>* root;

    public:

    BST() {
        size = 0;
        left = NULL;
        right = NULL;
        root = NULL;
    }

    BST(DT data, BST<DT>* root) {

        this->data = data;
        size = 1;
        left = NULL;
        right = NULL;
        this->root = root;
    } 

    BST<DT>* getLeft() {
        return left;
    }

    BST<DT>* getRight() {
        return right;
    }

    DT getData() {

        return data;

    }

    void setLeft(BST<DT>* left) {
        this->left = left;
    }

    void setRight(BST<DT>* right) {
        this->right = right;
    }

    void setData(DT data) {
        this->data = data;
    }

    BST* insertNode(BST* newNode, BST* root) {

        if (root == NULL) {
            root = newNode;
            return root;
        }

        if (newNode->getData() < root->getData()) {

            root->setLeft(insertNode(newNode, root->left));
        }

        else if (newNode->getData() > root->getData()) {

            root->setRight(insertNode(newNode, root->right));
        }

        return root;
    }

    BST* removeNode(BST* nodeToRemove, BST* root) {

        if (nodeToRemove->getData() < root->getData() ) {

            if (nodeToRemove->getData() == root->getLeft()->getData()) {

                BST* temp = root->getLeft();
                root->setLeft(root->getLeft()->getLeft());
                root->getLeft()->setRight(temp->getRight());
                delete temp;

            }

            else {

                removeNode(nodeToRemove, root->getLeft());
            }

        }

        else if (nodeToRemove->getData() > root->getData()) {

            if (nodeToRemove->getData() == root->getRight()->getData()) {

                BST* temp = root->getRight();
                root->setRight(root->getRight()->getRight());
                root->getRight()->setLeft(temp->getLeft());
                delete temp;
            }

            else {

                removeNode(nodeToRemove, root->getRight());
            }
        }

        return nodeToRemove;
    }

    BST* findNode(DT data, BST* root) {

        if (data < root->getData()) {

            if (data == root->getLeft()->getData()) {

                return root->getLeft();
            }

            else {

                findNode(data, root->getLeft());
            }
        }

        else if (data > root->getData()) {

            if (data == root->getRight()->getData()) {

                return root->getRight();
            }

            else {

                findNode(data, root->getRight());
            }
        }

        cout << "Node not found" << endl;
        return nullptr;
    }

};

int main() {

    BST<int>* JoshTree = new BST<int>(5, NULL);

    JoshTree->insertNode(new BST<int>(3, JoshTree), JoshTree);

    cout << JoshTree->findNode(3, JoshTree)->getData() << endl;

    JoshTree->insertNode(new BST<int>(2, JoshTree), JoshTree);

    JoshTree->insertNode(new BST<int>(7, JoshTree), JoshTree);

    JoshTree->removeNode(JoshTree->getLeft(), JoshTree);

    cout << JoshTree->findNode(2, JoshTree)->getData() << endl;
    
}