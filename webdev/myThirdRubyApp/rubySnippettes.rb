def string_shuffles(s)
    s.split('').shuffle.join
end
string_shuffle("foobar")
=> "oobfra"

class String
    def shuffle
        self.split('').shuffle.join
    end
end
"foobar".shuffle
=> "borafo"