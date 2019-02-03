/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    int size;

    void clear() {

        if (size != 0) {
            for (int i = 0; i < storage.length; i++) {
                if (storage[i] == null) {
                    if ((i + 1) < storage.length) {
                        if (storage[i + 1] != null) {
                            storage[i] = storage[i + 1];
                            storage[i + 1] = null;
                        }
                    }
                }
            }

            int notNullValue = 0;

            for (int i = 0; i < storage.length; i++) {
                if (storage[i] != null)
                    notNullValue++;
            }
            size = notNullValue;
        }
    }

    void save(Resume r) {
        if (size != 0) {
            for (int i = 1; i <= size; i++) {
                if (storage[i] == null) {
                    storage[i] = r;
                }
            }
        } else {
            storage[0] = r;
        }

        size++;
    }

    Resume get(String uuid) {
        boolean contains = false;
        for (int i = 0; i < size; i++) {
            if (storage[i].uuid.equals(uuid)) {
                return storage[i];
            }
        }
        return null;
    }

    void delete(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].uuid.equals(uuid)) {
                storage[i] = null;
                clear();
                break;
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return storage;
    }

    int size() {
        return size;
    }
}
