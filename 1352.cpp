// https://leetcode.com/problems/product-of-the-last-k-numbers/description/?envType=daily-question&envId=2025-02-14

class ProductOfNumbers {
public:
    ProductOfNumbers() {
        products.push_back(1); 
    }
    
    void add(int num) {
        if (num == 0) {
            products.clear();
            products.push_back(1); 
        } else {
            products.push_back(products.back() * num);
        }
    }
    
    int getProduct(int k) {
        int n = products.size();
        if (k >= n) return 0; 
        return products.back() / products[n - k - 1]; 
    }

private:
    vector<int> products; 
};
