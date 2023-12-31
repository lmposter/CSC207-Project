package data_access;

import entity.Product;
import entity.ProductFactory;
import entity.Review;
import interface_adapter.API.DatabaseAPI;
import use_case.create_product.CreatePdDAI;
import use_case.productDetails.ProductDetailsDAI;
import use_case.search.SearchDAI;

import java.io.*;
import java.util.*;

public class ProductDAO implements SearchDAI, CreatePdDAI, ProductDetailsDAI
{
    private final File csvFile;
    private final ProductFactory productFactory;
    private final Map<String, Integer> headers = new LinkedHashMap<>();
    private Map<String, Product> products;

    private Map<String, String> productSeller;

    public ProductDAO(String csvPath, ProductFactory productFactory)
    {
        this.productFactory = productFactory;
        this.csvFile = new File(csvPath);
        this.products = new HashMap<>();
        this.productSeller = new HashMap<>();
        headers.put("id", 0);
        headers.put("title", 1);
        headers.put("inventory", 2);
        headers.put("URL", 3);
        headers.put("price", 4);
        headers.put("reviews", 5);
        headers.put("seller", 6);

        if (csvFile.length() == 0)
        {
            //            save();
        } else
        {
            createProducts();
        }
    }

    private void createProducts()
    {
        try (BufferedReader reader = new BufferedReader(new FileReader(csvFile)))
        {
            String header = reader.readLine();

            if (header.equals("id,title,inventory,URL,price,reviews,seller"))
            {
                String row;
                while ((row = reader.readLine()) != null)
                {
                    String[] col = row.split(",");
                    String id = String.valueOf(col[headers.get("id")]);
                    String title = String.valueOf(col[headers.get("title")]);
                    int inventory = Integer.parseInt(col[headers.get("inventory")]);
                    String URL = String.valueOf(col[headers.get("URL")]);
                    double price = Double.parseDouble(col[headers.get("price")]);
                    String username = String.valueOf(col[headers.get("seller")]);
                    int reviewsIndex = headers.get("reviews");
                    ArrayList<Review> reviews = new ArrayList<>();
                    String[] reviewContent = col[reviewsIndex].split(";");
                    for (String review : reviewContent)
                    {
                        if (review.length() >= 1)
                        {
                            String[] StarAndComment = review.substring(1, review.length() - 1).split(",");
                            if (StarAndComment.length == 2 && !StarAndComment[0].isEmpty())
                            {
                                reviews.add(new Review(Integer.parseInt(StarAndComment[0]), StarAndComment[1]));
                            }
                        }
                    }
                    Product product = productFactory.create(title, URL, price, inventory);
                    product.setID(id);
                    for (Review review : reviews)
                    {
                        product.addReview(review);
                    }
                    products.put(id, product);
                    productSeller.put(id, username);
                }
            } else
            {
                throw new IOException();
            }
        } catch (IOException e)
        {
            System.out.println("Can't read file in ProductDAO createProducts");
            System.exit(1);
        }
    }


    private void save()
    {
        BufferedWriter writer;
        try
        {
            writer = new BufferedWriter(new FileWriter(csvFile));
            writer.write(String.join(",", headers.keySet()));
            writer.newLine();

            for (Product pd : products.values())
            {

                String line = String.format("%s,%s,%s,%s,%s,%s,%s", pd.getId(), pd.getTitle(), pd.getInventory(), pd.getURL(), pd.getPrice(), pd.getReview(), productSeller.get(pd.getID()));

                writer.write(line);
                writer.newLine();
                System.out.println("one product created");
            }

            writer.close();

        } catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int numItemsFound(String content)
    {
        String[] KeyWords = content.split(" ");
        int s = 0;
        for (Product pd : products.values())
        {
            String title = pd.getTitle();
            for (String word : KeyWords)
            {
                if (title.contains(word))
                {
                    s++;
                }
            }
        }
        return s;
    }


    @Override
    public ArrayList<Product> getItems(String content)
    {
        ArrayList<Product> pdList = new ArrayList<>();
        String[] KeyWords = content.split(" ");
        for (Product pd : products.values())
        {
            String title = pd.getTitle();
            for (String word : KeyWords)
            {
                if (title.contains(word))
                {
                    pdList.add(pd);
                }
            }
        }
        return pdList;
    }

    @Override
    public void save(Product product, String username)
    {
        products.put(product.getID(), product);
        productSeller.put(product.getID(), username);
        this.save();
    }


    @Override
    public boolean productExists(String PdID)
    {
        //        try (BufferedReader reader = new BufferedReader(new FileReader(csvFile))) {
        //            String header = reader.readLine();
        //
        //            if (header.equals("id,title,inventory,URL,price")) {
        //
        //                String row;
        //                while ((row = reader.readLine()) != null) {
        //                    String[] col = row.split(",");
        //                    String id = String.valueOf(col[headers.get("id")]);
        //                    if (Objects.equals(id, PdID)){
        //                        return true;
        //                    }
        //                }
        //                return false;
        //            } else {
        //                throw new IOException();
        //            }
        //
        //        } catch (IOException e) {
        //            System.out.println("Can't read file in ProductDAO productExists");
        //            System.exit(1);
        //        }
        //        return false;
        return products.containsKey(PdID);
    }

    @Override
    public Product getPd(String PdID)
    {
        return products.get(PdID);
    }

    @Override
    public void buyProduct(String name, String id, String title, Double price)
    {
        DatabaseAPI.buyProduct("name", name, id, title, price);
    }

    @Override
    public ArrayList<Product> findProducts(String username)
    {
        ArrayList<Product> result = new ArrayList<>();
        for (Map.Entry<String, String> entry : productSeller.entrySet())
        {
            String pID = entry.getKey();
            String sellerName = entry.getValue();
            if (Objects.equals(sellerName, username))
            {
                result.add(products.get(pID));
            }
        }
        return result;
    }

}