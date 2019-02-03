import java.util.ArrayList;
import java.util.List;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    void clear() {
        List<Resume> list = new ArrayList<>();
        if(size() != 0) {
            for (Resume resume : storage) {
                if (resume.uuid != null)
                    list.add(resume);
            }
        }

        storage = list.toArray(new Resume[list.size()]);
    }

    void save(Resume r) {
        clear();
        List<Resume> list = new ArrayList<>();
        for (Resume resume : storage) {
            list.add(resume);
        }

        list.add(r);
        storage = list.toArray(new Resume[list.size()]);
    }

    Resume get(String uuid) {
        boolean contains = false;
        for (Resume resume : storage) {
            if (resume.uuid.equals(uuid)) {
                return resume;
            }
        }
        return null;
    }

    void delete(String uuid) {
        boolean contains = false;
        for (Resume resume : storage) {
            if (resume.uuid.equals(uuid)){
                resume.uuid = null;
                contains = true;
            }
        }
        if(!contains) System.out.println("You don't have " + uuid + " in the storage");
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        clear();
        return storage;
    }

    int size() {
        int size = 0;
        for (Resume resume : storage) {
            if (resume != null) {
                size++;
            } else {
                break;
            }
        }
        return size;
    }
}
